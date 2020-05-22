Smartlist smartlist = smartlistRepository.findOne(smartlistDTO.getSmartlistId());
// take an existence reference
AccountEmailing accountEmailing = smartlist.getAccountEmailing();
// perform update on accountEmailing
smartlist.setAccountEmailing(accountEmailing);
smartlistRepository.save(smartlist);