ArrayList<String>killAdmins; //or whatever
File saved_items = new File("saved.txt")
try {   
     PrintWriter pw1 = new PrintWriter(new FileOutputStream(saved_items));
        for(String item_to_save : killAdmins){
          pw1.append(item_to_save + "\n");
        } 
        pw1.append("-----------")
        pw1.close();
      }