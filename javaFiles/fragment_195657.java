<script>
$(document).ready(function(){
    var continuar = true;
    var positionNumber = 0;
    var flagPressedButton = false;
    var i=0;
    $(".clickme").click(function(event){

        for(i; i < 10;){

            ajaxOne();
                 i++;
                 if(continuar == false) break;

        }


      $("body").on('click', '.btn-default', function(e) {
          console.log('ok we finish no more calls to servlets');
          $('#myModal').modal('hide')   ;
          console.log('BUT LETS CONTINUE WITH THE FOR.... WE HAVE TO CHECK ALL THE ITEMS')
        $(".clickme").click();
      });

      $("body").on('click', '.btn-primary', function(e) {
          console.log('ok lets call now ajax three');
          ajaxThree();
        $(".clickme").click();
      });

    });



function ajaxOne(){
    $.ajax({
           type: "POST",
             url: "/Test/one",
           //contentType : "text/xml",

           async :false ,
           beforeSend: function () {
               continuar =true;
                 positionNumber++;
               console.log('CALLING POSITION: '+positionNumber);
             console.log('Call Servlet one')
                },
             success: function(data,status,xhr){
                console.log('complete: ', JSON.parse(data));
                var statusCode = JSON.parse(data).responseCode;
                console.log('satusCode: ', statusCode);
                if (statusCode) {
                    ajaxTwo(statusCode);
                }
                                      },
                error: function(xhr, status, error){
                  alert("Error!" + xhr.status);
                         }

           });

}


    function ajaxTwo(){
        var text;
        $.ajax({
               type: "POST",
                 url: "/Test/two",
               //contentType : "text/xml",
               async :false ,
               beforeSend: function () {
                 console.log('Call Servlet two')
                    },
                 success: function(data,status,xhr){
                    console.log(data);
                    text = data;

                                          },
                    error: function(xhr, status, error){
                      alert("Error!" + xhr.status);
                             },
                         complete: function(){
                             console.log('finish Call Servlet two')

                            if(parseInt(text)==2){
                                console.error('LLAMARE A LA MODAL');
                                   $('#myModal').modal('show')   ;
                                   continuar = false;
                            }else{
                                ajaxFour();
                            }
                            }

               });

    }

    function ajaxThree(){
        $.ajax({
               type: "POST",
                 url: "/Test/three",
               //contentType : "text/xml",
               async :false ,
               beforeSend: function () {
                 console.log('Call Servlet three')
                    },
                 success: function(data,status,xhr){
                    console.log(data);

                                          },
                    error: function(xhr, status, error){
                      alert("Error!" + xhr.status);
                             },
                         complete: function(){
                             console.log('finish Call Servlet three')
                                                            console.error('CERRARE A LA MODALA Y CONTINUARE');
                             $('#myModal').modal('hide')   ;
                             ajaxFour();
                             continuar = true;
                            }

               });

    }

    function ajaxFour(){
        $.ajax({
               type: "POST",
                 url: "/Test/four",
               //contentType : "text/xml",
               async :false ,
               beforeSend: function () {
                 console.log('Call Servlet four')
                    },
                 success: function(data,status,xhr){
                    console.log(data);

                                          },
                    error: function(xhr, status, error){
                      alert("Error!" + xhr.status);
                             },
                         complete: function(){
                             console.log('finish Call Servlet four')
                            }

               });

    }
});
</script>