// let's presume that you've loaded the lines into "List<String> lines"..

// empty ArrayList for storing the selected lines
List<String> linesToWrite = new ArrayList<>();

for(String line : lines)
{
    if(line.startsWith("[0-9]"))
    {
        linesToWrite.add(line);
    }
}
// and now write it to the other file