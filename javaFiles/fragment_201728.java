@Override
protected void onResume() {
try {
    super.onResume();
    FontLoader.loadFonts(this);
    headerLayout.LoadHeaderFont();
    footerLayout.LoadFooterFont();
    FontLoader.setRalewayBoldFont(mSubMenuHeaderTv);
    FontLoader.setAwesomeFont(mSubMenuBackTv);
    FontLoader.setAtlasFont(mSubMenuIconTv);
    loadSubMenuLabel();
    subMenuAdapter.setList(AtlasApplication.lstLawsForLocation);
    mNotificationLv.setAdapter(subMenuAdapter);
    mNotificationLv.post(new Runnable() {
        @Override
        public void run() {
            mNotificationLv.smoothScrollToPosition(21);
        }
    });

    activityResumed();
}
catch(Exception e){
    exceptionHandler.handle(e, "onResume()");
}