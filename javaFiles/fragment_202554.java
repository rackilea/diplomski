public void List<SelectItem> getDrawings(){
      if(drawings == null) {
           drawings = sessionBean.getAllDrawings();
      }
      return drawings;
}