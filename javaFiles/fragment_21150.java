public class ClassBuilder
{

  public static String buildClass(String className,ArrayList<String> methods)
  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(String.format("public class %s \n{", className)).append("\n");
    for (String method: methods)
    {
      stringBuilder.append(String.format("    %s \n    {", method.trim().replace("static ","").replace("()","_test()"))).append("\n    }\n\n");      
    }
    stringBuilder.append("}");
    return stringBuilder.toString();
  }

  public static void main(String[] args)
  {
    Scanner scanner = null;
    try
    {
      scanner = new Scanner(new File("d:\\testFile.txt"));

      ArrayList<String> methods = new ArrayList<String>();
      while (scanner.hasNext())
      {
        methods.add(scanner.nextLine());
      }
      scanner.close();

      String javaClass = buildClass("className", methods);

      System.out.println(javaClass);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
  }

}