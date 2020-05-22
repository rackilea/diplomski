while(data.next()) 
        {
            Integer remainldgs = (int)data.getDouble("RemainLdgs");
            int position = data.getInt("Position");
            String itemNum = data.getString("Itemnum");
            String tmt = data.getString("TMT_Description");
            object = ac.getAircraftRegistration()+" - Engine "+position+" - task - "+itemNum;
            description=tmt+"\n Scheduled for : ";
            System.out.println(data.getMetaData().getColumnName(8)+" est de type : "+data.getMetaData().getColumnTypeName(8));
            /*
            read some other stuff
            */
    }