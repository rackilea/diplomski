// Setup dummy array
    ArrayList<Integer> list = dateArray;
    int counter = 1;
outerwhileloop:
    while (list.size() != 0) {
        for (int j = 1; j < list.size(); j++)
        {

            //System.out.println(list.get(0) + " and " + list.get(j));
            int difference = list.get(0) - list.get(j);
            if (difference <6){
                System.out.println(list.get(0) + " and " + list.get(j) + " and size is " +list.size() );    
                counter= counter +1;
                System.out.println ("Counter is " + counter);
                if (counter >= 4){
                    System.out.println ("j = " + j + " Counter =" + counter);   
                    if (j ==list.size()-1) {
                        System.out.println ("here " + counter); 
                        break outerwhileloop;
                    }   
                }
            }
        }
        list.remove(0);
    };