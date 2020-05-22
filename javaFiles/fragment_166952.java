public A findParticularA(int id)
{
    if (this.getID == id) 
    {
        return this;
    }  
    else 
    {
        return findAHelper(this, id);  # here
    }
}

public A findAHelper(A root, int id)
{
    for(A a : root.getChildren())
    {
        if(a.getID == id) 
        {
            return a;
        }
        else
        {
            tmp = findAHelper(a, id);    # here
            if (tmp is not null) {       #
                return tmp               #
            }
        }
    }
    return null;
}