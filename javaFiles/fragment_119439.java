$.ajax({
        type: "GET",
        dataType:"jsonp",
            crossDomain: true,
        url:  "http://url:port/DynamicReportsService/dynamicReports",
        jsonpCallback: 'successCallback',
        success: function(data1) {
            console.log("response:" + data1);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            $("#loadingimageid").remove();
            alert('generateReportFromMR:Error in processing!');
            console.log(jqXHR);
        }
    });