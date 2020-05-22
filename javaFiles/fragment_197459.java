xmlhttp.send(empJson);
    xmlhttp.onreadystatechange = function() {               
   if(xmlhttp.readyState == 4){
        var result= xmlhttp.responseText;           
    }
    }