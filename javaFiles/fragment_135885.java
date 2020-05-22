if(aF != null)
    {
        for (ParseObject NewFiles : aF) 
        {
            adapter.add((String) NewFiles.get("ImageName"));
        }
    }