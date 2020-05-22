public class SelectableInfo {
    private final ObservableList<SomeInfo> infoList = FXCollections.observableArrayList() ;

    private SomeInfo selectedInfo ;

    public ObservableList<SomeInfo> getInfoList() {
        return infoList ;
    }

    public SomeInfo getSelectedInfo() {
        return selectedInfo ;
    }

    public void setSelectedInfo(SomeInfo info) {
        selectedInfo = info ;
    }
}