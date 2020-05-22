function fetchLogs(){
$.ajax({
    type: "POST",
    url: "LogsServlet",
    data: 'FromDate='+from+'&'+'ToDate='+to,
    dataType: 'json',
    success: AjaxFetchDataSucceeded,
    error: AjaxFetchDataFailed

});

}

function AjaxFetchDataSucceeded(result) {
    if (result != "[]") {
        //var dataTab = $.parseJSON(result);
        $('#logs').dataTable({
            "bProcessing": true,
            "aaData": result,
            //important  -- headers of the json
            "aoColumns": [{ "mDataProp": "user_id" }, { "mDataProp": "executed_at" }],
            "sPaginationType": "full_numbers",
            "aaSorting": [[0, "asc"]],
            "bJQueryUI": true

        });
    }
}

function AjaxFetchDataFailed(result) {
    alert(result.status + ' ' + result.statusText);
}