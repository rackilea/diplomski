Iterator<LinkedInAccountObject> iterator = laoarray.iterator();
while(iterator.hasNext()){
    LinkedInAccountObject lao = iterator.next()
    LinkedInPageObject lpo = new LinkedInPageObject();
    lpo.setCompanyID(lao.getParentId());
    lpo.setComment(lao.getComment());
    //remaining of your code.
}