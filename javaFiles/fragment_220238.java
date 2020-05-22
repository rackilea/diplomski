function first_send(){
    // Local Variable
    var xmlhttp;            

        // Create Object
    if (window.XMLHttpRequest){ // IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    } else {                    // IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

        // Set Function
    xmlhttp.onreadystatechange=function(){
      if (xmlhttp.readyState==4 && xmlhttp.status==200){
        // (1) Check reply from server if request has been successfully 
        //     received
        // (2) Set flag / Fire-off next function to send
        // Example
        if (xmlhttp.responseText == "ReceiveSuccess"){
          secondSend();
        } else {
          // Error handling here
      } 
      } 
    }

        // Gets the first set of Data you want to send
    var postString = getPostString();  

          // Send
    xmlhttp.open("POST","form1.php",true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
       xmlhttp.setRequestHeader("Content-length", postString.length);
       xmlhttp.setRequestHeader("Connection", "close");
    xmlhttp.send(postString);
}