FileWriter writer = null;

    if(tasklist.equals(true))
    {
        writer = new FileWriter(tasklist);
    }
    else
    {
        writer = new FileWriter(tasklist, true);
    }