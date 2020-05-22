for(int i = 0; i < students.length; i++){
                     System.out.println("---------------------------------------");
                     System.out.println( i + (students[i] == null));
                     if(students[i] != null){
                         students[i].getFullPrint();
                     }
                     System.out.println("");
             }