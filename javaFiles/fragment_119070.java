@Test
public void testLoadFromFile()
{
  //...init
  FileHandler fh = new FileHandler(new ArrayList<>(), new ArrayList<>());
  result = fh.loadFromFile(known_path_to_File);
  assertEquals(expectedMap, result);
  // **here you can be sure that the file was read correctly!**
}