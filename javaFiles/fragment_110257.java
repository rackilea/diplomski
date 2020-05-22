Ember.$.ajax({
    type: "GET",
    url: App.serverURL + 'logVisit',
    data : {
        'fp': App.fp
    },
    dataType : "JSON",
    xhrFields: {withCredentials: true}, // line added
    ....
});