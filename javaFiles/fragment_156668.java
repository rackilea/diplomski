String last = ""; // initially, last is empty

while (scanner.hasNextLine())
{

    String line = scanner.nextLine();
    String text = last + " " + line; // two-line buffer

    if (text.contains(findWord))
    {
        count++;
    }

    last = line; // remember the last line read

} //end search loop