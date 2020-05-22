for (String text : allrecords[z])
{
    if (text == null)
    {
        continue;
    }
    theDisk.writeSector(z, text.getBytes());
}