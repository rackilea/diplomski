private ArrayList<String> Person = new ArrayList<String>();
public static void main(String[] args) throws Exception
{
  // readArray();
  fileHandling fh = new fileHandling();
  fh.readArray(fh.readFile()); // <-- something like this
}