$.getJSON('TotalUsers.json', function(data) {
    var valuesTotal = [];
    var daysTotal = [];
    $.each(data.day, function(key, obj) {
        valuesTotal.push('<li id="value-' + key + '">' + obj["@value"] + '</li>');
        daysTotal.push('<li id="day-' + key + '">' + obj["@date"] + '</li>');
    });
});​