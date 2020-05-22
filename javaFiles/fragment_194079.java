File dir = new File("storage/emulated/0/wifip2pshared/" + dirName); 
try { 
      if (!dir.exists()) { 
          if (dir.mkdir()) { 
              System.out.println("Directory created"); 
           } else { 
              System.out.println("Directory is not created"); 
           } 
     } 
 } catch (Exception e) { 
        e.printStackTrace(); 
 }