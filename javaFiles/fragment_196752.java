public Siamese(int weightPounds, int age, String ownerName, String catName, String gender)
{
    this.weightPounds = weightPounds;
    this.age = age;
    this.ownerName = ownerName;
    this.catName = catName;
    this.gender = gender;
}

public HouseCat()
{
    if(catName == null || catName.equals(""))
    {
        feral = true;
    }
}