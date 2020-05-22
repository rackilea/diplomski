HTMLCode += "<form name='month' 
   onclick=\"window.open('availability.jsp?
   user=99&clickeddate="+dateFormat.format(today.getTime())+"&month=" + avail.getMaand() +
   "','_self')\">";

                ^
                |
                |
             This one