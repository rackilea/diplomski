function reloadReqdForm(){

var url = "something.do?queryString";
       if (window.XMLHttpRequest) {
           req = new XMLHttpRequest();
       } else if (window.ActiveXObject) {
          req = new ActiveXObject("Microsoft.XMLHTTP");
        }
       req.open("POST", url, true);
       req.onreadystatechange = callbackReloadForm;
       req.send(null);
}
function callbackReloadForm()
 {
 if (req.readyState == 4) 
 {
    if (req.status == 200) {
        drawResponse();
      }
 }
}

function drawResponse() {
var message = req.responseText;
     document.getElementById("div1").innerHTML=message;
}