public static void a(int b){
if(b<0)
    return;
System.out.println(b);
a(b-1);
System.out.println(b + " is done");
}