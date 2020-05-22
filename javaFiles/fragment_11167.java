Map<Animal, Summary> result = new HashMap<Animal, Summary>();

class Animal
{
    String date;

    String name;

    public Animal(final String date, final String n)
    {
        this.date = date;
        this.name = n;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Animal))
        {
            return false;
        }
        Animal other = (Animal) obj;
        if (date == null)
        {
            if (other.date != null)
            {
                return false;
            }
        }
        else if (!date.equals(other.date))
        {
            return false;
        }
        if (name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        }
        else if (!name.equals(other.name))
        {
            return false;
        }
        return true;
    }
}

final static class Summary
{
    private int total;

    private int count;

    void setTotal(int value)
    {
        total = value;
    }

    void setCount(int i)
    {
        count = i;
    }

    void increaseCount()
    {
        count++;
    }

    void addToTotal(int valueToAdd)
    {
        total += valueToAdd;
    }
}