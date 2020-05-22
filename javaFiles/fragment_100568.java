int counter = 0;

for (Entry<String, Integer> entry : existingFile.entrySet() )
{
    if (counter == 5)
        break;

    builder.append("{" + entry.getKey() + "," + entry.getValue() + "}   ");
    counter++;
}