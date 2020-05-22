/* ArrayList<String> messages; */
   ArrayList messages;

   /* for (String message : messages) */
   for (Iterator it = messages.iterator(); ; it.hasNext()) {
       String message = it.next();
       ...
   }

   /* String.format("%1$td/%1$tm/%1$tY %1$tI:%1$tM:%1$tS %1$Tp", new Date()) */
   new SimpleDateFormat("your-desired-format").format(new Date());