try{ 
        Medicine medicine= TrueMDAPI.getMedicineData(drugdetail);
        printMedicine(medicine);         
       }finally {            
        out.close();
     }