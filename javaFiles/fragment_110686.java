import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DbValidator
{

  public static void main(String[] args)
  {
    if (args.length < 0)
    {
      return;
    }

    Path lvRootPath = Paths.get(args[0]);

    findAndParse(lvRootPath);
  }

  private static void findAndParse(Path pmPath)
  {
    File lvDir = pmPath.toFile();

    if (!lvDir.exists())
    {
      return;
    }

    File[] lvFiles = lvDir.listFiles();

    for (File file : lvFiles)
    {
      if (file.isDirectory())
      {
        findAndParse(file.toPath());
      }
      else
      {
        if (file.getName().endsWith(".java"))
          parseFile(file.toPath());
      }
    }
  }

  private static void parseFile(Path pmPath)
  {
    // System.out.println("#Validating file: " + pmPath);
    try
    {
      List<String> lvLines = Files.readAllLines(pmPath,Charset.forName("UTF-8"));
      Map<String, Integer> lvConNames = new HashMap<String, Integer>(); // map var-name : level;
      Map<String, Integer> lvPsNames = new HashMap<String, Integer>();
      Map<String, Integer> lvRsNames = new HashMap<String, Integer>();
      List<Integer> lvTryBlocks = new ArrayList<Integer>(); // opened try blocks
      int lvLevel = 0;
      int lvLineIdx = 1;

      for (String line : lvLines)
      {
        lvLevel = checkLevel(line,lvLevel);
        closeTryBlocks(lvTryBlocks,lvLevel);
        checkIfConectionGetter(lvTryBlocks,line,lvLineIdx,pmPath);

        line = line.trim();

        if (line.startsWith("Connection"))
        {
          String lvName = line.replaceFirst("Connection\\s","").replaceAll("\\s*=\\s*(.)*+","");
          lvConNames.put(lvName,lvLevel);
          lvLineIdx++;
          continue;
        }
        else if (line.startsWith("PreparedStatement"))
        {
          String lvName = line.replaceFirst("PreparedStatement\\s","").replaceAll("\\s=\\s*(.)*+","");
          lvPsNames.put(lvName,lvLevel);
          lvLineIdx++;
          continue;
        }
        else if (line.startsWith("ResultSet"))
        {
          String lvName = line.replaceFirst("ResultSet\\s","").replaceAll("\\s=\\s*(.)*+","");
          lvRsNames.put(lvName,lvLevel);
        }
        else if (line.startsWith("try"))
        {
          lvTryBlocks.add(lvLevel);
          lvLineIdx++;
          continue;
        }
        else if (line.startsWith("StreamUtils.closeQuietly"))
        {
          String[] lvElements = line.replaceAll("StreamUtils.closeQuietly\\(","").replaceAll("\\);","").split(",");

          boolean lvWasPs = false;
          boolean lvWasCon = false;

          for (String element : lvElements)
          {
            element = element.trim();

            if (lvPsNames.get(element) != null)
            {
              lvPsNames.remove(element);
              if (lvWasCon)
              {
                System.out.println("#######################################################################");
                System.out.println("#!!! Warning at file \"" + pmPath + "\" at line: " + lvLineIdx);
                System.out.println("#Wrong closing order");
                System.out.println("#######################################################################");
              }

              lvWasPs = true;
            }
            else if (lvRsNames.get(element) != null)
            {
              lvRsNames.remove(element);

              if (lvWasCon || lvWasPs)
              {
                System.out.println("#######################################################################");
                System.out.println("#!!! Warning at file \"" + pmPath + "\" at line: " + lvLineIdx);
                System.out.println("#Wrong closing order");
                System.out.println("#######################################################################");
              }
            }
            else if (lvConNames.get(element) != null)
            {
              lvConNames.remove(element);
              lvWasCon = true;
            }
          }
        }

        Map<String, Integer> lvConNamesTmp = new HashMap<String, Integer>(lvConNames);
        for (Entry<String, Integer> entry : lvConNamesTmp.entrySet())
        {
          Integer lvValue = entry.getValue();

          if (lvValue > lvLevel)
          {
            System.out.println("#######################################################################");
            System.out.println("#!!! Warning at file \"" + pmPath + "\" at line: " + lvLineIdx);
            System.out.println("#Not closed Connection");
            System.out.println("#######################################################################");
            lvConNames.remove(entry.getKey());
          }
        }

        Map<String, Integer> lvPsNamesTmp = new HashMap<String, Integer>(lvPsNames);
        for (Entry<String, Integer> entry : lvPsNamesTmp.entrySet())
        {
          Integer lvValue = entry.getValue();

          if (lvValue > lvLevel)
          {
            System.out.println("#######################################################################");
            System.out.println("#!!! Warning at file \"" + pmPath + "\" at line: " + lvLineIdx);
            System.out.println("#Not closed PreparedStatement");
            System.out.println("#######################################################################");

            lvPsNamesTmp.remove(entry.getKey());
          }
        }

        Map<String, Integer> lvRsNamesTmp = new HashMap<String, Integer>(lvRsNames);
        for (Entry<String, Integer> entry : lvRsNamesTmp.entrySet())
        {
          Integer lvValue = entry.getValue();

          if (lvValue > lvLevel)
          {
            System.out.println("#######################################################################");
            System.out.println("#!!! Warning at file \"" + pmPath + "\" at line: " + lvLineIdx);
            System.out.println("#Not closed ResultSet");
            System.out.println("#######################################################################");

            lvRsNames.remove(entry.getKey());
          }
        }

        ++lvLineIdx;
      }

    }
    catch (Exception e)
    {
      // System.out.println("#Parsing error at file: " + pmPath);
      // e.printStackTrace();
    }
  }

  private static void checkIfConectionGetter(List<Integer> pmTryBlocks, String pmLine, int pmLineIndex, Path pmPath)
  {
    if (pmLine.indexOf("DbUtils.getConnection") != -1 && pmTryBlocks.isEmpty())
    {
      System.out.println("#######################################################################");
      System.out.println("#!!! Warning at file \"" + pmPath + "\" at line: " + pmLineIndex);
      System.out.println("#!!! Connection initialize outisde of try block");
      System.out.println("#######################################################################");
    }
  }

  private static void closeTryBlocks(List<Integer> pmTryBlocks, int pmLevel)
  {
    int lvIndexOf = pmTryBlocks.indexOf(new Integer(pmLevel));

    if (lvIndexOf != -1)
    {
      pmTryBlocks.remove(lvIndexOf);
    }
  }

  private static int checkLevel(String pmLine, int pmCurrentLevel)
  {
    // check level
    int lvIndexOfStart = -1;
    int lvIndexOfEnd = -1;
    int lvLevel = pmCurrentLevel;

    String lvLineTmp = pmLine;

    do
    {
      if (lvLineTmp.indexOf("}") != -1)
      {
        lvLineTmp = lvLineTmp.replaceFirst("\\}","");
        lvLevel--;
      }
      else if (lvLineTmp.indexOf("{") != -1)
      {
        lvLineTmp = lvLineTmp.replaceFirst("\\{","");
        lvLevel++;
      }
      else
      {
        break;
      }

    }
    while (true);

    return lvLevel;
  }

}