public void dbStConClose() {
      try {
        if(getSt()!=null){
            getSt().close();
        }
      } catch (SQLException ex) {
          Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
      }

      try {
        if(getCon()!=null){
            getCon().close();
        }
      } catch (SQLException ex) {
          Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
      }
}