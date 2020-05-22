public static void main(String[] args) throws ParseException {
    String input="hello 1:2.3.4";
    MessageFormat form = new MessageFormat("{0} {1,number}:{2,number,integer}.{3,number}");
    Object[] data = form.parse(input);
    for(Object o : data) {
        System.out.println(o.getClass()+" : "+o.toString());
    }
}