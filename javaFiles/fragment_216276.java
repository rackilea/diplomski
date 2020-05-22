String searchCategory = "food";
List<Record> matches = new ArrayList<Records>();

for (Record r : records)
{
    String currentCategory = r.getCategory();

    // this will do case-insensitive matches
    if (currentCategory.equalsIgnoreCase(searchCategory))
    {
        matches.add(r);
    }
}