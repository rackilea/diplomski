function saveDataURL(a) {
    var postData = "canvasData="+encodeURIComponent(a);
    var ajax = new XMLHttpRequest();
    ajax.open("POST",'uploadPhoto.cgi',true);
    ajax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    ajax.send(postData);    
}