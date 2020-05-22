....

private void setCommonValues(BaseDocument doc, CmsDocument cmsDocument) {
    doc.setType(cmsDocument.getType());
    doc.setName(cmsDocument.getName());
    doc.setContentId(cmsDocument.getText(CONTENT_ID_PATH));
}



public DownloadAppComponent map(CmsDocument cmsDocument) {
    DownloadAppComponent downloadAppComponent = new DownloadAppComponent();

    // Call setCommonValues 
    setCommonValues(downloadAppComponent, cmsDocument);

    downloadAppComponent.setIosURL(cmsDocument.getText(IOS_URL_PATH));
    downloadAppComponent.setAndroidURL(cmsDocument.getText(ANDROID_URL_PATH));
    downloadAppComponent.setHidden(Boolean.parseBoolean(cmsDocument.getText(HIDE_PATH)));
    downloadAppComponent.setPromoText(cmsDocument.getText(DOWNLOAD_PROMO_TEXT_PATH));

    return downloadAppComponent;
}