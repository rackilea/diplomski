static void filereader(Scanner textfile)     
{         
    int i = 0;         
    int sum = 0;          
    while(i <= 19)         
    {       
        int nextInt = textfile.nextInt();          

        System.out.println(nextInt);             
        sum = sum + nextInt;
        i++;         
    }     
}