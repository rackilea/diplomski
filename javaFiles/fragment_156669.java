String text = "";

if (scanner.hasNextLine())
{
    text += scanner.nextLine(); // first line
}
while (scanner.hasNextLine())
{
    text += " "; // separate lines with a space
    text += scanner.nextLine();
}

int found, offset = 0; // start looking at the beginning, offset 0
while ((found = text.indexOf(findWord, offset)) != -1)
{
    count++; // found a match
    offset = found + 1; // look for next match after this match
}