public void onScanButtonPress(@ButtonFlashMode int button)
{
    ScanState.ScanModeEnum newMode;
    @ButtonFlashMode int btnMode = 0;

    switch (button)
    {
        case FLASH_BIKE:
            newMode = ScanState.ScanModeEnum.SCAN_BIKE;
            btnMode = FLASH_BIKE;

        case FLASH_PERSON:
            newMode = ScanState.ScanModeEnum.SCAN_PERSON;
            btnMode = FLASH_PERSON;

        default:
            //Unhandled.
            return;
    }

    if (ScanState.getScanMode() != ScanState.ScanModeEnum.SCAN_IDLE)
    {
        //We're already scanning, but user wants to stop.
        stopScanning();
    }
    else
    {
        ScanState.setScanMode(newMode);
        restartScan();
        buttonFlashMode = btnMode;
        buttonFlasher();
    }
}