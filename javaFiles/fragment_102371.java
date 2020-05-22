public class Mapper {
    private void setCommonValues(BaseDocument doc, CmsDocument cmsDocument) {
        doc.setType(cmsDocument.getType());
        doc.setName(cmsDocument.getName());
        doc.setContentId(cmsDocument.getText(CONTENT_ID_PATH));
    }

    public BaseDocument map(CmsDocument cmsDocument, Class<? extends BaseDocument> clazz) {
        BaseDocument doc = null;
        if (clazz.getCanonicalName().equals(DownloadAppComponent.class.getCanonicalName()) {
            DownloadAppComponent appComponent = new DownloadAppComponent();
            doc = appComponent;
            appComponent.setIosURL(cmsDocument.getText(IOS_URL_PATH));
            appComponent.setAndroidURL(cmsDocument.getText(ANDROID_URL_PATH));
            appComponent.setHidden(Boolean.parseBoolean(cmsDocument.getText(HIDE_PATH)));
            appComponent.setPromoText(cmsDocument.getText(DOWNLOAD_PROMO_TEXT_PATH));

        } else {
             doc = new BaseDocument();
        }
        setCommonValues(doc);
        return doc;
    }
}