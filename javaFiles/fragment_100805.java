public List<Platnosc> createDocumentForInvoice(Integer fakturaId) {

   AuthUser user = loginMgr.getLoggedUser();

   Platnosc plat = Platnosc.builder()
        // I don't set field platnoscNr here it is null
        .build();

    platDao.save(plat);
    entityManager.flush();
    entityManager.refresh(plat);

    return plat;
}