function callActionUsingAjax(urlAction, dataFields, callback) {
    $.ajax({
        type: "post",
        url: urlAction,
        data: dataFields,
        success: function (data) {
            callback(data);
        },
        error: function (data) {
            // Somehow process the validation messages,
            // like you seem to be doing already.
        }
    });

    // etc...
}