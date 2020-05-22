@Mapper
public interface MerchantsMapper {

    @Mapping(target = "supports_api", ignore = "true")
    MerchantNewDTO toNewDTO(Merchant merchant);

    @AfterMapping
    default applyFeatures(@MappingTarget MerchatNewDTO merchantNewDTO, Merchant merchant) {

        MerchantConfigurationUtils merchant_config = new MerchantConfigurationUtils();
        Map<MerchantConfigurationFeatureBitString, Boolean> features = merchant_config.initFromDatabaseValue(merchant.getSupported_features());

        merchatNewDTO.setSupports_api(features.get(MerchantConfigurationFeatureBitString.Supports_api));
    }
}