@Configuration
public class MyConfig {
    @Bean
    public PromoCodeInterceptor promoCodeInterceptor() {
        PromoCodeInterceptor promoCodeInterceptor = new PromoCodeInterceptor();
        promoCodeInterceptor.setPromoCode("OF3RTA");
        promoCodeInterceptor.setErrorReidect("invalidPromoCode");
        promoCodeInterceptor.setOfferRedirect("products");
        return promoCodeInterceptor;
    }
}