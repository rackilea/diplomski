for(File file : search.listFiles())
    {
        String name = file.getName();
        boolean include = true;
        for(String exception : exceptions)
            if(name.contains(exception))
                include = false;
        if(include)
        {
            list.add(name);
            if(file.isDirectory())
            {
                addEverythingUnder(file,list,exceptions);
            }
        }
    }