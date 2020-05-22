import java.util.Scanner;
class FindMax{
    public static void main(String[] args){
        Scanner kybd=new Scanner(System.in);
        System.out.println("Enter 7 days\' temperature data");
        double temp[]=new double[7];
        for(int i=0;i<7;i++)
        temp[i]=kybd.nextDouble();
        double max=temp[0], min=temp[0];
        for(int i=1;i<7;i++){
            if(temp[i]>max)
                max=temp[i];
            if(temp[i]<min)
                min=temp[i];
        }
        System.out.println("Max temp : "+max);
        System.out.println("Min temp : "+min);
    }
}