public static void main(String[] args) {
    String [] testResult = {"+490232345678", 
                            "0049032345678", 
                            "+1 (555) 234-5078", 
                            "+7 (23) 45/6789+10", 
                            "(0123) 345/5678, ext. 666"};
    String reg = "^([\\(+ ]0| +|0+|\\(\\)|\\+)| +|[^\\d]+|/$";
    for (String phone : testResult) {
        System.out.println(phone.replaceAll(reg, ""));
    }
}