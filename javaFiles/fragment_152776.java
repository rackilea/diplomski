$.getJSON("MyServlet", paramenters, function (data){ 
   var data1=data[0], data2=data[1]; //We get both data1 and data2 from the array
   $("h3#name").text(data1["name"]); 
   $("span#level").text(data1["level"]); 
   $("span#college").text(data2["college"]); 
   $("span#department").text(data2["department"]);
});