private void synCampaignWithRetries(int ntries, int msecsRetry) {
    while(ntries-- >=0 ) {
       try {
         synCampaign();
         return; // no exception? success
       } 
      catch (ApiException e ) {
           // log exception?
      }
      catch (RemoteException e ) {
           // log exception?
      }
      try {
           Thread.sleep(msecsRetry);
      } catch (InterruptedException e1) {
           // log exception?
      }
   }
   // no success , even with ntries - log?
}

private void synCampaign() throws ApiException ,RemoteException {
    List<Campaign> campaigns = AdwordsCampaign.getAllCampaign();
    for(Campaign c : campaigns) 
            CampaignDao.save(c);
}