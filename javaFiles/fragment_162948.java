List<String> playersList = new ArrayList() ;
        if(!message.equals("")){
            playersList.add(message);
        }
        etc..  

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, playersList);