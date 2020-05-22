new DefaultBusinessPartnerService().createBusinessPartnerAddress(someAddress)
    .asChildOf(
        someBusinessPartner,
        BusinessPartner.TO_BUSINESS_PARTNER_ADDRESS
    )
    .execute();