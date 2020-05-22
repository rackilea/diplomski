if(menuOption == 1){
            double[] results = addition(array1,array2);
            for(int i = 0; i<arraysize; i++)
                System.out.print(results[i]+" ");
            menuOption=getMenuOption();
        }