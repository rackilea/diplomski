document.getElementById('select1').onchange = function(){
    var xmlhttp=new XMLHttpRequest();
    var params = "id="+this.value           //you can add more data, use & as delemitter

    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length", params.length);
    xmlhttp.setRequestHeader("Connection", "close");

    xmlhttp.onreadystatechange=function(){
        if (xmlhttp.readyState==4 && xmlhttp.status==200){
            fillSelect(xmlhttp.responseText);
        }
    }

    xmlhttp.open("POST","path/to/php.php",true);
    xmlhttp.send(params);
}

var fillSelect = function(response){
    //Here you can go through all elements from response 
    //and build new options and append them to Select2
}