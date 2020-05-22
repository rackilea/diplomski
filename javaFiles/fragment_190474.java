File handle = null;
        String parent = "";
        String lastName = "";

        for (int i = 0; i < 14; i++)
        {
            if (i == 0)
            {
                handle = new File(file);
                parent = handle.getParent();
            }
            else
            {
                lastName = parent + File.separator + randomName();
                handle.renameTo(new File(lastName));
                handle = new File(lastName);
            }

        }