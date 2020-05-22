public UpdateClass(Activity context) {
    //this.context also should be Activity, so please make it as a Activity Reference
    this.context = context;

    db = new DAO(context);
    db.open();

    lastAuthor = db.getLastAuthor();
    lastQuote = db.getLastQuote();

    siteUrl = context.getResources().getString(R.string.siteUrl);
    updatesUrl = siteUrl + "site/get_updates/" + String.valueOf(lastAuthor)
            + "/" + String.valueOf(lastQuote);

    auPictureDir = siteUrl + "global/uploads/levels/";

}