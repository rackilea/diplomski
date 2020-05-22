int compare(myType obj1, myType obj2)
{
    // first compare age
    if (obj1.age == 3)
    {
        if (obj2.age == 3)
        {
            // ages are both 3, so count eggs
            return obj1.eggs.compareTo(obj2.eggs);
        }
        // age 3 sorts before everything else
        return -1;
    }
    else if (obj2.age == 3)
    {
        // if obj2.age is 3, and obj1.age isn't 3,
        // then obj1 is greater than obj2
        return 1;
    }

    // compare color
    return obj1.color.compareTo(obj2.color);
}