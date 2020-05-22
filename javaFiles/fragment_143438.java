for (int i = 0; i < list.size(); i++){
       if(list.get(i).subjectCode.contains(s))
       {
          System.out.println("Subject is found:" +list.get(i).subjectCode);
       }
       else{
          System.out.println("Subject not found.");
       }
    }