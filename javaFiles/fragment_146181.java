public class ScanResultsListWrapper implements IWifiListWrapper<ScanResult>      {
    private List<ScanResult> mScanResults;

    @Override
    public boolean doesListContains(IWifiInfo wifiInfo) {    
        ...
    } 
    @Override
    public void setList(List<ScanResult> wifiList) {
        ...
    }
}