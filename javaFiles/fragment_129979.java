// Iterator mapIt = numbers.keySet().iterator(); - you can only iterate thru map by using iterator

    for(int i = min; i <= max; i++){
        Iterator it = numbers.get(i).iterator();
        System.out.print("Iterating for number " + i+": ");
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
    }