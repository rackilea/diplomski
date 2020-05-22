writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(pathtoyourfile+".arff",true), "utf-8"));
        writer2 =  new PrintWriter(pathtoyourfile+".arff", "UTF-8");
        writer2.println("@Relation Users");
        writer2.println("");
        writer2.println("@attribute id string");
        writer2.println("@attribute bDate string");
        writer2.println("@attribute name string");
        writer2.println("@attribute sName string");
        writer2.println("@attribute description string");
        writer2.println("@attribute city string");          
        writer2.println("");
        writer2.println("@data");
        writer2.close();

        String[] entries =  new String[6];
        //lets say you have a list with users
        List<User>  users = .....

        for(int i=0;i<users.size();i++){
             entries[0]= users.get(i).getId();
             entries[1]= users.get(i).getbDate();
             .....
             entries[5]= users.get(i).getCity();
             writer.writeNext(entries);
        }
        writer.close();