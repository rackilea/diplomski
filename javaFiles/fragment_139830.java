public static void a(int b){
if(b<0)
   return;

System.out.println(b);

a(b-1);
a(b+1); //assuming this didn't go to infinity
}