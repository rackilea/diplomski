if(document.getElementById("fundingType")==null){
        console.log("input doesn't exist");
    }
    else{
        console.log("input exists");
        formReq.removeChild(document.getElementById("fundingType"));
    }