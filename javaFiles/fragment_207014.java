if (StringUtils.isNotBlank(customerVO.getBirthDate())) {
    mstCustomer.setDob(DateUtils.getUtilDate(customerVO.getBirthDate()));
}

if (StringUtils.isNotBlank(customerVO.getCity())) { 
    MstCity city = mstCityRepository.findByName(customerVO.getCity()); 
    mstCustomer.setMstCity(city); 
}