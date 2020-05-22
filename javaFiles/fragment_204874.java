public static void possibilities(int length,String sofar,double[]itemCost,double money){
    if(length==0){
        //selectFood(sofar,itemCost,money,0);
        float totCost=0;

        double target=money/1.15;
        double minTip=money-target;

        char[]sofarList=sofar.toCharArray();
        for(int i=0;i<sofarList.length;i++){
            if(sofarList[i]=='1'){
                totCost+=itemCost[i];
            }

        }
        if(totCost<target && totCost>max){
            max = totCost;
            System.out.println(totCost);
            for(int i=0;i<sofarList.length;i++){
                System.out.print(sofarList[i]);
            }   
            System.out.println("\n");
        }

    }
    else{
        possibilities(length-1,sofar+"0",itemCost,money);
        possibilities(length-1,sofar+"1",itemCost,money);
    }
}