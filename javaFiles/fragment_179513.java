public class Mystery
{
    public static void main(String []args){
        Mystery strange = new Mystery();
        strange.mystery(1234);
    }

    public void mystery(int x){
        System.out.print(x%10);
        if((x/10) != 0){
            mystery(x/10);
        }
        else{
              System.out.print(0);
         }
    }
}