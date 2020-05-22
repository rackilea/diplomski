function fixPositioning(panelId) {
    var popupPanel = document.getElementById(panelId);
    if (popupPanel) {
        popupPanel.style.visibility = "hidden";
        popupPanel.style.display = "block";
    }
}