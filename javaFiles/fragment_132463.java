public class AndroidAdsManager implements AdsManager{

    private Integer interstital;

    public AndroidAdsManager(){  
        interstital = 0;
    }

    @Override
    public void showAds(){
       //Show ads method
    }
    @Override
    public Integer getInterstital(){
        return interstital;
    }
}