@Subscribe
@AllowConcurrentEvents
    public void receivedDicomFile(TirEvent event){                  

        try {



            } catch (ClassNotFoundException e) {
                logger.error(e.getMessage());
            } catch (SQLException e) {
                logger.error(e.getMessage());
            } catch(Exception e){
                logger.error(e.getMessage());
            }



    }