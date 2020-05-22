case "Search Duplicate Value":
        {   
        search = (String) JOptionPane.showInputDialog(null , "Search Duplicate Value" , "Search" , JOptionPane.INFORMATION_MESSAGE);
            int parseSearchDuplicate = Integer.parseInt(search);
            boolean isduplicate=false;
            for(int i = 0; i < arrayElements.length ; i++)
            {               
                if(arrayElements[i] == parseSearchDuplicate && i == parseSearchDuplicate)
                {
                    isduplicate=true;
                    equalisStringDuplicate = equalisStringDuplicate + " " + arrayElements[i];                   
                }   
            }           
        }
        If(isduplicate)
JOptionPane.showMessageDialog(null , new Label(equalisStringDuplicate + " "),  "Duplicate Value is:" , JOptionPane.INFORMATION_MESSAGE);                                
  else 
      //show no duplicate found
        equalisStringDuplicate = "";
        break;