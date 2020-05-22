@Override
    public boolean updateStoreDetails(List<StoreDetailsDTO> storeDetailsDTOs){
        Session session = this.hibernateSessionFactory.getCurrentSession();
        int count = 0;
        boolean sessionEnded =false;

        for(StoreDetailsDTO storeDetailsDTOTmp : storeDetailsDTOs){         
            session.saveOrUpdate(storeDetailsDTOTmp);
            //session.evict(storeDetailsDTOTmp);
            if ( ++count % 50 == 0 ) {      //If batch size is 50 clear session-level cache & to avoid OutOfMemoryException
                  logger.info("Clearing session after 50 batch size.");               
                  session.flush();
                  session.clear();                
            } 
        }       
        return true;
    }