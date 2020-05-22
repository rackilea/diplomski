public class Palindrome {
        public static void main(String[] args) {
            for(int i=0;i<=25000;i++){
                int number=i;
                int reverse=0;
                int temp=0;
                while(number>0){
                    temp=number%10;
                    number=number/10;
                    reverse=reverse*10+temp;
                   // System.out.println(rev);
                    if(i==reverse){
                    if(reverse%2!=0){
                        System.out.println(reverse);
                    }
                }
                }
            }
        }
    }