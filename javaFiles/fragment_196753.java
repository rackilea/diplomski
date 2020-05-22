public HouseCat(String ownerName, String catName)
{
    this.ownerName = ownerName;
    this.catName = catName;
    if(catName == null || catName.equals(""))
    {
        feral = true;
    }
}