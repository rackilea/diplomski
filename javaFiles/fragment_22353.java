if (!checkPermission()) {
    openActivity();
} else {
    if (checkPermission()) {
        requestPermissionAndContinue();
    } else {
        openActivity();
    }
}