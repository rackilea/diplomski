Scanner keyboard = new Scanner(System.in);
       List<String> inputItems = new ArrayList<String>();       
       List<String> printedResults = new ArrayList<String>();
       String input = keyboard.nextLine();       

       while(!"!checkout".equals(input)) 
       {           
           inputItems.add(input);           
           input = keyboard.nextLine();
       }

       for(int i=0; i<inputItems.size();i++)
       {
           Integer thisItemCount = 0;
           String currentItem = inputItems.get(i);

           for(int j=0; j<inputItems.size();j++)
           {
                if(inputItems.get(j).toLowerCase().equals(currentItem.toLowerCase()))    
                    thisItemCount++;
           }

           if(!printedResults.contains(currentItem.toLowerCase()))
           {
               System.out.println(currentItem.toLowerCase() + " x" + thisItemCount);
               printedResults.add(currentItem.toLowerCase());
           }               
        }