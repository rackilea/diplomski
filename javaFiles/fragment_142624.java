class Mamal
{
    String Name;
    double fat;
    double protein;
    public Mamal(double fatContent,double proteinContent,String nameofElements)
    {
        Name=nameofElements;
        protein=proteinContent;
        fat=fatContent;
    }
    public String get_by_name(Mamal[] nameofElements,String name)
    {
        for(int i=0;i<nameofElements.length;i++)
        {
            if(nameofElements[i].getName().equalsIgnoreCase(name))
            {
                return nameofElements[i].getFat()+nameofElements[i].getName();
            }
        }
        return "";
    }
    public String getName() {
        return Name;
    }
    public double getFat() {
        return fat;
    }
    public double getProtein() {
        return protein;
    }
}