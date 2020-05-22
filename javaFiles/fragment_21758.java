success: function (data) {
    if(data.status == "SUCCESS") {
        // Update labels in page
    } else {
        errorInfo = "";
        for(i =0 ; i < data.result.length ; i++) {
            errorInfo += "<br>" + (i + 1) +". " + data.result[i].code;
        }
        //add a div with id error to show errors.
        $('#error').html("Please correct following errors: " + errorInfo);
    }
},