...
...
xhr.send(null);

xhr.onreadystatechange = function () {
    if(xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200){
        //deal with response
        var res = xhr.responseText;

         //for testing
         if (res == "") {
            window.alert("I'm getting nothing");
         }

        view.showVehicleList(res);
    }
};