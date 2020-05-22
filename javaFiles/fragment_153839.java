while(inFile.hasNext())
{
    int num; 
    num = inFile.nextInt(); 
    System.out.print(num);
    for(int i=0; i < num; i++) 
    { 
        System.out.print("*"); 
    } 
    System.out.println();
}