static File f1;
static PrintWriter pw;

static void levelWithLargestNumberOfNodes(Lab5BTNode root) throws Exception
{

    f1 = new File("temp.txt");
    pw = new PrintWriter("temp.txt");
    boolean b1 = f1.createNewFile();
    //System.out.println(b1);
    if(!b1){
        for(int i = 0 ; i < (one.height(root)); i++)
        {
            printElementsOnALevel(one.root,i);
            pw.println();
        }
        pw.flush(); pw.close();
    }

    boolean b2 = f1.exists();
    //System.out.println(b2);

    if(b2)
    {
        Scanner sc = new Scanner(f1);
        int count = 0;
        String lev0="",lev1="",lev2="",lev3="",lev4="",lev5="",lev6="",lev7 = "",lev8 = "",lev9 = "",lev10 = "";
        while (sc.hasNextLine())
        {
            if(count==0)
                lev0 = sc.nextLine();
            if(count==1)
                lev1 = sc.nextLine();
            if(count==2)
                lev2 = sc.nextLine();
            if(count==3)
                lev3 = sc.nextLine();
            if(count==4)
                lev4 = sc.nextLine();
            if(count==5)
                lev5 = sc.nextLine();
            if(count==6)
                lev6 = sc.nextLine();
            if(count==7)
                lev7 = sc.nextLine();
            if(count==8)
                lev8 = sc.nextLine();
            if(count==9)
                lev9 = sc.nextLine();
            if(count==10)
                lev10 = sc.nextLine();
            count++;
        }
        StringTokenizer tokens = new StringTokenizer(lev0," ");
        int firstcount = tokens.countTokens();
        //System.out.println(firstcount);

        StringTokenizer tokens1 = new StringTokenizer(lev1," ");
        int secondcount = tokens1.countTokens();

        StringTokenizer tokens2 = new StringTokenizer(lev2," ");
        int thirdcount = tokens2.countTokens();

        StringTokenizer tokens3 = new StringTokenizer(lev3," ");
        int fourthcount = tokens3.countTokens();

        StringTokenizer tokens4 = new StringTokenizer(lev4," ");
        int fifthcount = tokens4.countTokens();

        StringTokenizer tokens5 = new StringTokenizer(lev5," ");
        int sixthcount = tokens5.countTokens();

        StringTokenizer tokens6 = new StringTokenizer(lev6," ");
        int seventhcount = tokens6.countTokens();

        StringTokenizer tokens7 = new StringTokenizer(lev7," ");
        int eighthcount = tokens7.countTokens();

        StringTokenizer tokens8 = new StringTokenizer(lev8," ");
        int ninthcount = tokens8.countTokens();

        StringTokenizer tokens9 = new StringTokenizer(lev9," ");
        int tenthcount = tokens9.countTokens();

        StringTokenizer tokens10 = new StringTokenizer(lev10," ");
        int eleventhcount = tokens10.countTokens();

        int temp[] = {firstcount,secondcount,thirdcount,fourthcount
            ,fifthcount,sixthcount,seventhcount,eighthcount,ninthcount,tenthcount,eleventhcount};

            int maxValue = temp[0]; 

    for(int i=1;i < temp.length;i++)
    { 
        if(temp[i] > maxValue)
        { 
            maxValue = temp[i]; 

        }
    }System.out.println("Levels with max number of Nodes i.e "+maxValue+" nodes are as follows : " );

            if(maxValue == firstcount)
                System.out.println(lev0);
            if(maxValue == secondcount)
                System.out.println(lev1);
            if(maxValue == thirdcount)
                System.out.println(lev2);
            if(maxValue == fourthcount)
                System.out.println(lev3);
            if(maxValue == fifthcount)
                System.out.println(lev4);
            if(maxValue == sixthcount)
                System.out.println(lev5);
            if(maxValue == seventhcount)
                System.out.println(lev6);
            if(maxValue == eighthcount)
                System.out.println(lev7);
            if(maxValue == ninthcount)
                System.out.println(lev8);
            if(maxValue == tenthcount)
                System.out.println(lev9);
            if(maxValue == eleventhcount)
                System.out.println(lev10);
        f1.delete();
    }

}