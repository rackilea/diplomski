public DownloadAppComponent(CmsDocument cmsDocument) {
     super(cmsDocument);
     this.setIosURL(cmsDocument.getText(IOS_URL_PATH));
     this.setAndroidURL(cmsDocument.getText(ANDROID_URL_PATH));
     this.setHidden(Boolean.parseBoolean(cmsDocument.getText(HIDE_PATH)));
    this.setPromoText(cmsDocument.getText(DOWNLOAD_PROMO_TEXT_PATH));

 }