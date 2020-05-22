$.post("second.jsp", {'name': name}, 
       function(data) 
       { 
          alert("Result from second.jsp: " + data.name + " " + data.type); 
       }
);