@Singleton
@Provides
IAdverticumChecker provideAdverticumChecker(BannerManager bannerManager){
    return new AdverticumChecker(bannerManager);
}
...
private BannerManager mBannerManager;
public AdverticumChecker(BannerManager bannerManager) {
    mBannerManager = bannerManager;
}