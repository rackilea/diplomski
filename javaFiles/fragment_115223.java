String[] bigParts = myString.split("\\|\\|");
for(String part : bigParts)
{
    String[] words = part.split("\\|");
    //save to db or what you want
}