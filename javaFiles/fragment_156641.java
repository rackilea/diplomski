public List<AppPortModel> getAppPortList() {
   List<ApServerModel> objLst =  mongoOperations.findAll(ApServerModel.class);
   String[] apServerArray = new String[objLst.size()];
   for(int i = 0; i < objLst.size(); i++) {
        apServerArray[i] = objLst.get(i).getHomeTown();
}