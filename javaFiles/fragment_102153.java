public class NextDiGui {
        public static void main(String[] args) {
                row();
        }
        static int num1 =0,  num2 =1;
        public static void row(){
                num1++;

                if(num1<10){
                        col();
                }
        }
        public static void col(){

                if(num2<=num1){

                        System.out.print(num1+"*"+num2+"="+num1*num2+"\t");
                        num2++;
                        col();
                }
                else{
                        num2=1;
                        System.out.println();
                        row();

                }
        }
}