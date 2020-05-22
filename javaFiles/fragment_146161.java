public static void main(String[] args) {

    int[] values = { 45, 50, 55, 60,59,58, 45, 40, 50, 55,54,53,55 };

    //keep track so that previous smaller element is also included
    boolean pair=false;
    for (int i = 1; i < values.length;i++ ) {

        if(values[i-1]<values[i]){
            if(!pair){
                System.out.println(values[i-1]);
                pair=true;
            }
            System.out.println(values[i]);
        }else{
            pair=false;
        }
    }
}