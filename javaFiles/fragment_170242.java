function doAddComment() {
    var url = "AddComment?commenttext="+newcommentcontent.value+"&postid="+postid.value;
    var req = getXHR();
    req.onreadystatechange = function()  
    { processRequestChange(req); 
      req.open("POST", url, true);
      req.send(null);
    }
}