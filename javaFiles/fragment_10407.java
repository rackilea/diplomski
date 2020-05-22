$(document).ready(function() {

    $(".delete").click(function() 
            {

                var productId=$(this).closest('tr').find("#productId").val();

                 var param = {productId:productId};

                $.ajax({
                  url: './deleteproduct',
                   data: param, 
                   type: 'post',
                    success: function(result) {
                    //find row to delete and use remove();
                  }
                });
            });

});