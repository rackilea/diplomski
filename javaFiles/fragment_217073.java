return "nothing".equalsIgnoreCase(message) ? "Are you sure?" : 
       "yes".equalsIgnoreCase(message) ? "ok" : null;
/* if message == "nothing" return "Are you sure?"
   if message == "yes" return "ok"
   if message != "yes" AND message != "nothing" return null 
   P.S: '==' and '!=' are for demonstration only. Keep using the .equals() 
   method for matching strings */