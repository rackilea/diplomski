private static void addfiles (File input,ArrayList<File> files)
    {
        if(input.isDirectory())
        {
            ArrayList <File> path = new ArrayList<File>(Arrays.asList(input.listFiles()));
            for(int i=0 ; i<path.size();++i)
            {
                if(path.get(i).isDirectory())
                {
                    addfiles(path.get(i),files);
                }
                if(path.get(i).isFile())
                {
                    String name=(path.get(i)).getName();
                    if(name.lastIndexOf('.')>0)
                    {
                        int lastIndex = name.lastIndexOf('.');
                        String str = name.substring(lastIndex);
                        if(str.equals(".txt"))
                        {
                            files.add(path.get(i));
                        }
                    }
                }
            }
        }
        if(input.isFile())
        {
            String name=(input.getName());
            if(name.lastIndexOf('.')>0)
            {
                int lastIndex = name.lastIndexOf('.');
                String str = name.substring(lastIndex);
                if(str.equals(".txt"))
                {
                    files.add(input);
                }
            }
        }

    }