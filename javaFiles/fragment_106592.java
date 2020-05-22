ArrayList<String> finalList = new ArrayList<String>();

    for (String[] string: arr) {

        if(string.length == 1)
        { 
            System.out.println(string[0]);
            finalList.add(string[0]);
            continue;
        }
        for (int i = 1; i < string.length; i++)  {
            System.out.println(string[0] + " " + string[i]);                
            finalList.add(string[0] + " " + string[i]);
        }   
    }

    for(String output: finalList){
        System.out.println(output);
    }