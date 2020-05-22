$.ajax({
        url : base_url + 'Upload_Servlet',
        type : "post",
        data:$('form').serialize(),             
        cache : false,
        success : function(data) {
            //do some stuff

    },
    error : function(xhr, status, err) {
        //do error stuff
    },
    timeout : 3000
    });
    //End ajax call