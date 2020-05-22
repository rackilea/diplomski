public static void main(String[] args) throws IOException {
    // TODO code application logic here
    BufferedReader filein = new BufferedReader(new FileReader("C:\\Employees.txt"));

    int count = Integer.parseInt(filein.readLine());
    String[] names = new String[count];
    int[] years = new int[count];
    int i;
    int pass;
    int loc;
    int temp;
    String tempNames;
    String passNames;

    System.out.println("My Company Employee Search");
    System.out.println("--------------------------");
    System.out.println("");



    for (i = 0; i < count ; i++) {
        names[i] = filein.readLine();
        years[i] = Integer.parseInt(filein.readLine());
        //System.out.println("")
    }//populate the arrays from filein


    for(int j=0;j<years.length;j++)
    {
        for(int k=0;k<j;k++)
        {
            if(years[j]>years[k])
            {
                temp=years[j];
                years[j]=years[k];
                years[k]=temp;

                tempNames=names[j];
                names[j]=names[k];
                names[k]=tempNames;
            }
        }
    }

    for(int j=0;j<years.length;j++)
    {
        System.out.println(" Name = "+names[j]+" And Year = "+years[j]);
    }
}