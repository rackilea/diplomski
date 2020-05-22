public void fugleType () 
    {
        System.out.println("Find observation by bird");
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader reader = null;
        try 
        {
            reader = new BufferedReader(new FileReader("fugler.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) 
            {
                lines.add(line);
            }
            reader.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }