request.onreadystatechange = function() {
   if(request.readyState == 4 && request.status == 200) {//if finish the ajax call and the status is ok
       message = request.responseText;
       console.log(message);
   };
   console.message('Checking the progress of the ajax call: ' + request.readyState);
}