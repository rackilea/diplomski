@Bean
@Qualifier("voucher")
public WebServiceTemplate getVoucherServiceTemplate() {...}

@Bean
@Qualifier("chargingGateway")
public WebServiceTemplate getChargingGatewayServiceTemplate() {...}