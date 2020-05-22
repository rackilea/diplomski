mntmNextItem.addActionListener(new ActionListener()
    {
        int i = 0;

        @Override
        public void actionPerformed(ActionEvent arg0) 
        {   
            if(i == filesInDirectory.length) {
                System.out.println("You are at the end");
            }        
            else {
                for (; i < filesInDirectory.length; i++) 
                {
                    if (filesInDirectory[i].isFile()) 
                    {
                        FileNames = filesInDirectory[i].getName();
                        if (FileNames.endsWith(".jpg") || FileNames.endsWith(".JPG"))
                        {
                            System.out.println(FileNames);
                            break;
                        }
                    }
                } 
            }
        }
    });