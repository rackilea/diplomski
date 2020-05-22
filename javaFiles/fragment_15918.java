int i = 0;
do{
    if(i == 5)
        // Won't print 5 but instead go back to the "top" of do
        // but first, will execute the while verification
        continue; 
    System.out.println(i);
}while(i++ < 10);