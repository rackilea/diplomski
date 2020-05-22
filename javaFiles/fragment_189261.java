try { 
  getErrText = toSearch.errorCell.getText();
  getErrText = (getErrText != null) ? getErrText.trim() : "";
}catch(Exception e){
  e.printStackTrace(); 
}