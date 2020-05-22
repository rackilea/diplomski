// creates a FileWriter Object
        if(tasklist.equals(true))
        {
            FileWriter writer = new FileWriter(tasklist);
        }
        else
        {
            FileWriter writer = new FileWriter(tasklist, true);
        }