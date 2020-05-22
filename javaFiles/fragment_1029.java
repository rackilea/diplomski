function closeMe()
        {     
            window.opener.location.reload(true); // reload parent page
            window.close(); // close this page                
      }

   $("#submitbtn").click(function(e) {
          e.preventDefault();

        var params = {
                    // here pass form parameter
                };

    $.ajax({
             type: "POST",
             url: "/analystServlet",
             data: params,
             success: function(data){ 

              $('body').css("background", "rgba(0,0,0,0.5)").fadeOut("slow");
               setTimeout(function () {
                  closeMe();
               }, 1000); // 1000 = 1 secs                                        
             }                        
    });  // end of $.ajax()