int lottMtch=0;

            for (int i = 0; i < 6; i++)
            {

               lottMtch += count(myArray[i], rndNum);

            }

                       if (lottMtch> 0)  
                            System.out.println(lottMtch + " matches found "+ rndNum);