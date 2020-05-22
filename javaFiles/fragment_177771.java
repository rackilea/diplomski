public static void main(String[] args){
        String n;
        String a[]={"zero","one","two","three","four","five","six","seven","eight","nine","ten", "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"}; 
        System.out.println("Enter number in words");
        Scanner sc=new Scanner(System.in);
        n=sc.next();
        for(int i=0;i<a.length;i++){
            if(n.equals(a[i])){
                System.out.println(i);
                break;
            }
        }
    }