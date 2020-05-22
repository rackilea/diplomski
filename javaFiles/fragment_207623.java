@RequestMapping(path = "get-bean", method = RequestMethod.GET)
public String getBean() {
    MyBean bean1 = new MyBean("name1", "11", null);
    MyBean bean2 = new MyBean("name2", "22", bean1);
    List<MyBean> beanList = new ArrayList<>();
    beanList.add(bean1);
    beanList.add(bean2);

    return convertToMyJson(beanList);
}