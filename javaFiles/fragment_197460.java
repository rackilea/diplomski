xmlhttp.send(JSON.stringify(empJson));
xmlhttp.onreadystatechange = function() {               
        if(xmlhttp.readyState == 4){
            var result= JSON.parse(xmlhttp.responseText);           
        }
        }