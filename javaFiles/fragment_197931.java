@FXML
void handleAliasDefault(ActionEvent event) {

    int sel = lsvAlias.getSelectionModel().getSelectedIndex();
    if (sel >= 0 && sel < lsvAlias.getItems().size()) {
        lsvAlias.setUserData(lsvAlias.getItems().get(sel));
        this.<DXSynonym>forceListRefreshOn(lsvAlias);
    }
}