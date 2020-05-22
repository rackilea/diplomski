SearchDialog seaerchDialog = new SearchDialog();
int ret = seaerchDialog.doModal();
if (SearchDialog.SEARCH == ret) {
    // get the search key entered on search dialog
    String key = seaerchDialog.getSearchKey();
}
else if (SearchDialog.CANCEL == ret) {
    // do something..
}