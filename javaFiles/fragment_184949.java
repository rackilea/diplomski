class ScanningPresenter {

    private final ScanningView scanningView;
    private final PermissionsChecker permissionsChecker;
    private final BluetoothAdapterWrapper bluetoothAdapterWrapper;

    ScanningPresenter(ScanningView scanningView, PermissionsChecker permissionsChecker, BluetoothAdapterWrapper bluetoothAdapterWrapper) {  
        this.scanningView = scanningView;
        this.permissionsChecker = permissionsChecker;
        this.bluetoothAdapterWrapper = bluetoothAdapterWrapper;
    }

    @Override
    public void startScanning() {
        if (isLocationPermissionGranted() && isBluetoothEnabled()) {
            scanningView.onStartScanBtnClick();
        } else if (!isBluetoothEnabled()) {
            scanningView.displayDialogRequestingBluetooth();
        } else if (!isLocationPermissionGranted()) {
            scanningView.displayDialogRequestingPermission();
        }
    }

    @Override
    public boolean isLocationPermissionGranted() {
        return permissionsChecker.isLocationPermissionGranted();
    }

    @Override
    public boolean isBluetoothEnabled() {
        return bluetoothAdapterWrapper.isEnabled();
    }
}