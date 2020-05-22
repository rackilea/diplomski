Sender Thread                              Receiver Thread

   msgBox.put(i);
                                             int element =  msgBox.get();
                                            System.out.println("Receiver got element : " + element);  
   System.out.println("Sender put element : " + i);