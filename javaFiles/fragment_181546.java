int size = 5;
String print = "";
for(int i=0;i<=size;i++) {
    print += "*";
    for(int j=size;j>i;j--) 
         print+= (i==0)?"*":" ";
    print += "*\n";
}