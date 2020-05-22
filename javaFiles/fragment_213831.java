$.subscribe('tabchange', function(event, data) {
    var tab = event.originalEvent.ui.newTab.attr("id");
    if (tab === "connected") {
        $("#activeTab").val(0);
    } else if (tab === "disconnected") {
        $("#activeTab").val(1);
    } else if (tab === "distribution") {
        $("#activeTab").val(3);
    }
});