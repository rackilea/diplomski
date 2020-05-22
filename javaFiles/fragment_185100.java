<script>
function checkExist(){

    $.ajax({
          type: "POST",
          url: "checkUser.jsp",
          data: {'fname':$("#FirstName").val(),'lname':$("#LastName").val()},
          success: function(data){
              console.log(data);
             var exist=data[0];



                //Query the jQuery object for the values

            if(exist>0){
                alert("user already exists!")
            }
          },
          dataType: "text"
        });

}

</script>