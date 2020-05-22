public void getAtmTotals(File file)     
    {

        Scanner rf = null;            
        for (String list : atmList)                         
        {               
        try
        {
            FileReader atmFile = new FileReader(file);
            Pattern p = Pattern.compile ("[\\s/\\s]+");
            rf = new Scanner (atmFile);                                        
            while (rf.hasNextLine())    
            {   
                if (rf.nextLine().contains("Total")) break;
                if (rf.nextLine().contains(list))
                {
                Scanner in = new Scanner(rf.nextLine()).useDelimiter(p);
                while (in.hasNext())                    
                    {                       
                        atmUs.add ( new Atm (in.next(), in.next(), in.next(), in.next(), in.nextFloat(), 
                                in.nextFloat(), in.nextFloat(), in.nextInt(), in.nextFloat(), in.nextInt(), 
                                in.nextFloat(), in.nextInt(), in.nextFloat(), in.nextInt() ) );                                                 
                    }               
                }
            }
        rf.close();
        }

        catch( FileNotFoundException fileNotFound)
        {
            System.err.println( "Error opening  " + file.getName());
            System.exit(1);
        }           

        catch ( NoSuchElementException elementEx)
        {
            System.err.println( "Incorrect " + file.getName() + " format");
            System.exit(1);
        }
        catch ( IllegalStateException stateEx )
        {
            System.err.println( "Error reading from " + file.getName());
            System.exit(1);
        }
        }

        System.out.print(atmUs);
    }