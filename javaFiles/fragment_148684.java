StringBuilder builder = new StringBuilder();
foreach (string line in Files.ReadAllLines(@"c:\myfile.txt"))
{
    builder.append(line);
}
String modified = builder.toString().replaceAll("\n ", " ");
FileWriter fw = new FileWriter(@"c:\myfile.txt");
fw.write(modified);
fw.close();