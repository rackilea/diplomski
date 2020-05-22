TelephonyManager telephonyManager = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
    List<CellInfo> cellList = telephonyManager.getAllCellInfo();
    CellInfoWcdma cellinfoWcdma = null;
    if(cellList!=null && !cellList.isEmpty()){
        cellinfoWcdma = (CellInfoWcdma)telephonyManager.getAllCellInfo().get(0);
        CellSignalStrengthWcdma cellSignalStrengthWcdma = cellinfoWcdma.getCellSignalStrength();
        if(Build.VERSION.SDK_INT>=18){
            cellSignalStrengthWcdma.getDbm();
        }
    }