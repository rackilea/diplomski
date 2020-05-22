Queue<int> emptySlots;
Object[] arrayOfStuff;

public void AddStuff(object stuffToAdd)
{
    if (this.emptySlots.Count > 0)
    {
        int index = this.emptySlots.Dequeue();
        //make sure your objects know their position in the array
        stuffToAdd.ID = index;
        this.arrayOfStuff[index] = stuffToAdd;            
    }
    else
    {
        //resize array and add new object to end rememebering to fetch its id
    }
}

public void RemoveStuff(object stuffToRemove)
{
    this.emptySlots.Enqueue(stuffToRemove.ID);
    this.arrayOfStuff[stuffToRemove.ID] = null;
}