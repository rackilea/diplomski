for (int i = 0; line != null; i++) {
        line = dataReader.readLine();
        if (line != null) {

            //line has 13 Strings to split
            temp = line.split(",");

            //making a larger duplicate with 15 indices instead of 13 as to add 2 more Strings
            System.arraycopy(temp, 0, temp2, 0, temp.length);

            /*
            my code to assign values to the two new 
            elements based data from the previous ones
            */

            //adding temp2 to my ArrayList
            dataArrayList.add(temp2);
            temp2 = new String[15];
        }
    }