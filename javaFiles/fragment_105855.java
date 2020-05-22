$downloadXLS = function(id)
{
    $.fileDownload('/user/exportXLS', 
    {
        httpMethod : "POST",
        data : {
            empId : id
        }
    }).done(function(e, response)
    {
     // success
    }).fail(function(e, response)
    {
     // failure
    });
}