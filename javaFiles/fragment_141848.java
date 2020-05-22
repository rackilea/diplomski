Scanner keyBoard=new Scanner(System.in);
    int number;
    ArrayList<Integer>numbers=new ArrayList<Integer>();
    boolean containsDuplicate = false;
    for (int i=0;i<6;i++){
        System.out.println("Number "+(i+1)+" : ");
        number=keyBoard.nextInt();
        numbers.add(number);
        for (int j=0;j<numbers.size()-1;j++){
            if (numbers.get(j) == number) {
                System.out.println(number+" is duplicate");
                containsDuplicate = true
                break;
            }
        } 
        if(containsDuplicate){
           break;
        }
    }
    for (int k=0;k<numbers.size()-1;k++){
        System.out.print(numbers.get(k));
    }