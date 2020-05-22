public void processChange(ValueChangeEvent event){        
try  {           
    logger.info("event new value "+event.getNewValue().toString());

} catch (NullPointerException ex)  { 
     logger.error("object is null: "+ex.getMessage());              
} catch (Exception ex)  { 
     logger.error(ex);              
}