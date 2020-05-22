$.ajax({
        url: "/BookStore/SelectProduct",
        data: {"id": id},
        type: 'POST',
        cache: false,
        success: function(response) {
            //  Add in what to do when ajax call is successful
        },
        error: function(xhr, ajaxOptions, thrownError) {
            alert('error');
        }