public class fibeven {
    public static void main(String args[]){
        int i1=1;
        int i2 = 2,temp;
    //System.out.println(i1);
    //System.out.println(i2);
        int sum = i2;
        while ((i1+i2)<4000000){
        //System.out.println(i1+i2);
            if((i1+i2)%2==0){
                sum = sum+i1+i2;
            }
            temp = i1;
            i1=i2;
            i2 = temp+i2;
        }
        System.out.println(sum);
    }
}