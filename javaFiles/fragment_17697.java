while (scan.hasNextLine())
    ;
{
    String stringRead = scan.nextLine();
    pw.println(lineNumber + ": " + stringRead);
    lineNumber++;
}