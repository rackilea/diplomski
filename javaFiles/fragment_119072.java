@Test(expected=IOException.class)
public void testFileNotFound()
{
  FileHandler fh = ...//same as previous
  fh = loadFromFile("no real file here.txt");
}