public static void main(String[] args) throws Exception{
    String s = "1";
    Constants constant = Constants.findByValue(s);
    if(null != constant){
        s = s.replaceAll(constant.getValue(), constant.name());
    }
    System.out.println(s);
}