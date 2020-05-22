function setMaintenanceMode(enabled) {
    var url = '<s:url action="secure/setMaintenanceMode"/>' + '&ModeEnabled=' + enabled;
    document.location.href = url;
    return false;
}

<a class="button" href="#" onclick="return setMaintenanceMode(false);">disable</a>