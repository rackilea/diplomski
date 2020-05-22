$("table").find("tr").each(function() {
   $thisElement = $(this);
   thisData = parseInt($thisElement.data("myId"), 10);

   myFunction(thisData);
});