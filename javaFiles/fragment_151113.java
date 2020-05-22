import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

  public void findfile(String path) {
    File f = new File(path);
    if (f.exists() && !f.isDirectory()) {
      System.out.println("file found.....!!!!");
      if (f.length() == 0) {
        System.out.println("file is empty......!!!!");

      }
    } else {
      System.out.println("file missing");
    }

  }

  public void readfilecontent(String path, String sql) {
    try {
      Scanner s = new Scanner(new File(path));
      ArrayList<String> list = new ArrayList<String>();
      while (s.hasNextLine()) {
        list.add(s.nextLine());
      }
      s.close();
      System.out.println(list);

      list.stream().forEach(regex -> {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(sql);
        if (m.find()) {
          System.out.println("match found for regex " + regex );
          System.out.println("matched substring: "+ m.group());
        } else {
          System.out.println("match not found for regex " + regex);
        }
      });

    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }

  }

  public static void main(String args[]) {

    String path = "/code/sql.pattern";
    String sql = "select * from schema.test";
    RegexMatches regex = new RegexMatches();
    regex.findfile(path);
    regex.readfilecontent(path, sql);

  }
}