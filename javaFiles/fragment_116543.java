while (inputStream.hasNext())
   {
         String content = inputStream.nextLine();
          // Move the condition and check with content variable.
               if ( content.matches("^\\d{3}\\.\\d{1}\\.\\d{1}\\.\\d{1}\\:\\d{4}"))
                {

                    System.out.println(content);
                }

                else 
                {
                    System.out.println("Not Valid");
                }
   }