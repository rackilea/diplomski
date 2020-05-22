createAjaxRequest("abcd",yourCallbackFuncationName);

function createAjaxRequest(requestURL,callbackFuncation){
    var xmlhttp;
    startStopLoader(true);
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    } else {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
        if (xmlhttp.readyState==4 ){

            if(xmlhttp.status == 200){
                try{
                    callbackFuncation(xmlhttp.responseText);
                }catch(e){

                }               
             }

        }
    }
    xmlhttp.open("GET",requestURL,true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");   
}

function yourCallbackFuncationName(response) {
        // you can manupulate your list stored in response variable 
        // you can generate your tr/td here and put it back in your main  
          table using innerHTML
}