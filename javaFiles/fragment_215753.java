String s = "rta=0.037ms;3000.000;5000.000;0; pl=10%;80;100;; rtmax=0.125ms;;;; rtmin=0.012ms;";
Pattern pattern = Pattern.compile("rta=(.*?);.*pl=(.*?);");
Matcher matcher = pattern.matcher(s);
if(matcher.find()){
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
}