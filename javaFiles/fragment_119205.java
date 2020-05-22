BufferedReader readerA = new BufferedReader(new FileReader("listA.txt"));
String lineA;
while ((lineA = readerA.readLine()) != null)
{
    BufferedReader readerB = new BufferedReader(new FileReader("listB.txt"));
    String lineB;
    while ((lineB = readerB.readLine()) != null)
    {
        compare(lineA, lineB);
    }
    // TODO: ensure .close() is called on readerB
}
// TODO: ensure .close() is called on readerA