public static void printInOrder(ArrayList<Integer> data){

    int minInteger = data.get(0);
    for(int i = 1; i < data.size(); i++){
        if(data.get(i) < minInteger) minInteger= data.get(i);
    }
    System.out.println(minInteger);

}