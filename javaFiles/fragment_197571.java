int lottMtch[]=new int[myArray.length];
           Arrays.fill(lottMtch, 0);
            for (int i = 0; i < 6; i++)
            {
                int chkNum = myArray[i];
               lottMtch[i] = count(chkNum, rndNum);

            }
            for (int i = 0; i < 6; i++)
            {
                       if (lottMtch[i] > 0)  
                            System.out.println(lottMtch[i] + " matches found "+ myArray[i]);
            }