public static void main(String[] args) throws Exception {
    final Map<String, String[]> params = new HashMap<>();
    params.put("userName", new String[]{"userA"});
    params.put("password", new String[]{"secrect"});
    params.put("id", new String[]{"10"});
    final JavaBean javaBean = new JavaBean();
    BeanUtilsBean.getInstance().populate(javaBean, params);
    System.out.println(javaBean.getUserName());
    System.out.println(javaBean.getPassword());
    System.out.println(javaBean.getId());

}