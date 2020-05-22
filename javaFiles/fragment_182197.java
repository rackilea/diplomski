package com.turreta.jaxb.unmarshaller.listener;

    public class PersonMarshallListener extends javax.xml.bind.Marshaller.Listener {

            int beforeCount = 1;
            int afterCount = 1;

          @Override
           public void beforeMarshal(Object source) {
              super.beforeMarshal(source);
              if (source instanceof Person) {

                  if (beforeCount == 2) {
                      beforeCount = 1;
                      System.out.println("BEFORE MARSHAL");
                  } else {
                      beforeCount++;
                  }
              }

           }

           @Override
           public void afterMarshal(Object source) {
               super.afterMarshal(source);

               if (source instanceof Person) {

                   if (afterCount == 2) {

                       afterCount = 1;
                       System.out.println("AFTER MARSHAL");
    //                 System.out.println("This will be called once the marshall has been completed");
                   } else {
                       afterCount++;
                   }
               }


           }

    }