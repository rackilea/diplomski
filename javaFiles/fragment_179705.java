String url = "token=1234235asdjaklj231k209a&name=sam&firname=Mahan";
url = url.replaceFirst("\\btoken=.*?(&|$)", "token=new_value$1");
System.out.println(url);
url = "param1=value&token=1234235asdjaklj231k209a";
url = url.replaceFirst("\\btoken=.*?(&|$)", "token=new_value$1");
System.out.println(url);