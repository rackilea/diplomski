int[] Bag = new int[0]; 
    String name = scanner.next();
    int[] NewBag;
    if (name.equals("A")){
        int number = scanner.nextInt();    
        NewBag = new int[Bag.length+1];// resize the array
        NewBag[NewBag.length - 1] = number;
        for(int i = 0; i < Bag.length; i++){
            NewBag[i] = Bag[i];
        }
        Bag = NewBag;
        System.out.println(number + " added to Bag.");
    }