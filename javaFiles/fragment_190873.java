List<BeanOne> finalBeanOne = new ArrayList<BeanOne>();
List<BeanOne> tempBeanOne = (List<BeanOne>) DAO.getBeanOneList();

for(BeanOne tempBean: tempBeanOne) {
    if(tempBean.getCustomerState().equalsIgnoreCase("MD") {
        finalBeanOne.add(tempBean);
    }
}