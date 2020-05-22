success: function(fp, o) {
    Ext.Msg.alert('Success', 'Form submitted.');
    Ext.Ajax.request({
        url: o.data.url,
        method: "GET",
        success: function(response, request) {
            // do whatever you need to with the generated HTML
            alert(response.responseText);
        },
        failure: function(response, request) {
            alert('failed');
        }
    });
}