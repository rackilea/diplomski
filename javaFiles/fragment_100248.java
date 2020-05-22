submitHandler : function(form) {
            let invalid = 0
            $(  ".userValue" ).removeClass( "has-error" )
            $( ".userValue" ).each(function() {

              if($( this ).val() == "" ) {
                invalid++
                $( this ).addClass( "has-error" );
              }
            });
            if(invalid == 0){
                //some logic
                form.submit();
            } 
        }