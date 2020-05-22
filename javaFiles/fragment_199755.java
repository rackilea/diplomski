while(data.hasNextLine())
    {
        //if you call nextLine() two times you will get two different items
        String data = data.nextLine();  
        ArrayData.add(i, data);

        if (data.contains("ID: "))
        {
            System.out.print(ArrayData.indexOf(data));  
           //check the index of data, but that should be equal to i. no idea what you want to do here?
        }
        i++;
    }