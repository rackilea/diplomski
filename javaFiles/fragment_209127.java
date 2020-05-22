List<String> list = Arrays.asList("123-456-2222","+1-123-456-2222","1234562222","12345622226","+11234562222");
Pattern p = Pattern.compile("^(\\+\\d{1,2}-?)?(\\d{3}-?){2}+\\d{4}$");

list.forEach(x -> {
    Matcher m = p.matcher(x);
    if(m.matches()) {
        System.out.println(x + " is Valid");
    } else {
        System.out.println(x + " is Invalid");
    }
});