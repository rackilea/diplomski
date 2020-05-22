import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.compile;

...

public static void main(String[] args) {
  BufferedReader r = null;
  try {
    r = new BufferedReader(new InputStreamReader(
        new FileInputStream("myfile.txt"), "UTF-8"));
    final Pattern p = compile("(.+?),(.+?),(.+?):(.+)");
    String line;
    while ((line = r.readLine()) != null) {
      final Matcher m = p.matcher(line);
      if (!m.matches())
        throw new RuntimeException("Line in invalid format: " + line);
      anotherclass.setBlock(parseInt(m.group(1)), parseInt(m.group(2)), 
          parseInt(m.group(3)), parseDouble(m.group(4)));
    }  
  }
  catch (IOException e) { throw new RuntimeException(e); }
  finally { try { if (r != null) r.close(); } catch (IOEXception e) {} }
}