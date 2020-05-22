@Override
public void setMinimumVoorraad(int minimumVoorraad) 
{
    if(minimumVoorraad <= 5)
        super.setMinimumVoorraad(6);
    else
        super.setMinimumVoorraad(minimumVoorraad);
}