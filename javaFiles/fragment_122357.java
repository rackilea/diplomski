@Inject
private AssetSource assetSource;

@Inject
private Locale locale;

public String getImageURL() {
    URL assetUrl = assetSource.getContextAsset("img/score/overall/" + getImageFilename(), locale).toURL();
    return assetUrl.toString();
}