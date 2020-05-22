static void bonAppetit(List<Integer> bill, int k, int b) {
    int sum=0;
    for(int i=0;i<bill.size();i++){
        sum+=bill.get(i);
    }
    sum-=bill.get(k);
    sum=sum/2;

    if(sum==b){
        System.out.println("Bon Appetit"); 
    }else{
        System.out.println(bill.get(k)/2);
    }

}