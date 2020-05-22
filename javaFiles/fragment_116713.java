void init() {                                                          
       imageView = itemView.findViewById(R.id.imageViewID);               
       imageView.setOnClickListener(new View.OnClickListener() {          
           @Override                                                      
           public void onClick(View v) {                                  
               if (isUp) {                                                
                   slideDown(v);                                          
               } else {                                                   
                   slideUp(v);                                            
               }                                                          
               isUp = !isUp;                                              
           }                                                              
       });                                                                
   }