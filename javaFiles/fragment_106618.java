TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
List<CellInfo> cellInfoList = tm.getAllCellInfo();
for (CellInfo cellInfo : cellInfoList)
{
    if (cellInfo instanceof CellInfoLte)
    {
        // cast to CellInfoLte and call all the CellInfoLte methods you need
        ((CellInfoLte)cellInfo).getCellSignalStrength().getDbm();
    }
}