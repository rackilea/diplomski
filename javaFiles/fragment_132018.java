int x = 0 , y = 1;

int num = 6;

System.out.println("0");
System.out.println("0 1");

String str = "0 1";

for(int i = 2 ; i < num ; i ++){
    int amt = x + y ;

    x = y;
    y = amt;

    str += " " + amt;

    System.out.println(str);

}