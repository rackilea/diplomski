function ccAllModel(checks) {
    for (var i = 0; i < 9; i++) {
        var vehicleId = "demoRptForm:vehicleTree:" + i + "::cbxNode";
        var array = document.getElementById(vehicleId);
        array.checked = checks.checked;
    }
}