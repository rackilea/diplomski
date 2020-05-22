int counter = 50;
for(int i = 100; i >= 0; i--)
{
    if(i == counter)
    {
        counter = counter / 2;
        this.entities.add(new Zombie(-535));
    }
}