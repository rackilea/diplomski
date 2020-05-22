class someClass(){
    ///some stuff
    public void performRestCall(int id_category){
    bus.register(this);
    ApiHelper.getItemsInCategory(id_category);
    }

    @Subscribe
    public void restCallCompleted(GetCategoryEvent e){
    ArrayList<Item> list = e.getList();
    //do whatever else you need to
    bus.unRegister(this);
    }
}