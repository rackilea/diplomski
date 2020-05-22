public static void main(String args[]){
    List<Integer>list= new ArrayList <Integer> ();
    list.add(20);
    list.add(30);
    list.add(70);
    list.add(50);
    list.add(60);
    list.add(40);
    int i =0;
    while(!list.isEmpty()) {  
        if(i%2==0){
            Object num=Collections.max(list);
            System.out.println(num);
            list.remove(num);
        }
        else if(i%2!=0) {
            Object num1=Collections.min(list);
            System.out.println(num1);
            list.remove(num1);
        }
        i++;
    }
}