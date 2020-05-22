@RequestMapping (value="/abcd",method=RequestMethod.GET) 
@ResponseBody
    public ItemsInABCDListBean getItemsInABCD(ModelMap map, HttpServletRequest req){
        LOGGER.info("ApplicationController :: ");       
        try { 
           ItemsInABCDListBean ItemsInABCDList = AppDAO.getItemsInABCDList();
        } catch (SQLException e) { 
            LOGGER.error("ApplicationController :: getItemsInABCDList:: SQLException ::"+e.getMessage()); 
        } 
        return ItemsInABCDList; // returns List you want to show
    }