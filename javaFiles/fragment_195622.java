DropDownChoice ddc = new DropDownChoice(id, model, choices){
   @Override
   protected String getNullKey(){ return "customDdcNullValue"; }
   @Override
   protected String getNullValidKey(){ return "customDdcNullValue"; }
}