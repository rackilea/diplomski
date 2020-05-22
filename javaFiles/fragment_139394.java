private void RenameFolder()
   {
       ArrayList CurrentName=new ArrayList();
       ArrayList NewName=new ArrayList();


       CurrentName.add(path);
       NewName.add(path);
       //repeat about two lines for as many folders you want.

       for(int i=0;i<CurrentName.size()-1;i++){

          File f1= new File(CurrentName.get(i));
          File f2= new File(NewName.get(i));

           try {
              if(f1.exists()) {
                 f1.renameTo(f2);
                 System.out.println("Folder " +f1.getName()+
                                   " was changed into " +f2.getName() +"..." );
            } else {
               f1.mkdir();
               System.out.println("Folder " +f1.getName()+ " was created..." );
           }
       } catch(Exception e) {
           e.printStackTrace();
       }

       }

   }