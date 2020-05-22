public Merchant saveMerchant(Merchant merchant) {
       merchant = merchantRepository.save(merchant);
        Merchant finalMerchant = merchant;
        merchant.getAddresses().forEach(address -> {
           address.setMerchant(finalMerchant);
           addressRepository.save(address);
       });
       return merchant;
    }