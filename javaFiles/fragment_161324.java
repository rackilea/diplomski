public static void addToList(int num, ArrayList<ArrayList<Integer>> list)
    //Splits the two parts of the number and inserts the arraylist into the proper arraylist
    {
      //  temp.clear();// this is the issue do below
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int numInt_one = Integer.parseInt(String.valueOf(num).substring(0,2));  
        int numInt_two = Integer.parseInt(String.valueOf(num).substring(2,4));  
        temp.add(numInt_one);
        temp.add(numInt_two);
        list.add(temp);
    }