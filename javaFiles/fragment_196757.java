String data="some string, 151.0.247.187, 54.239.167.92, 52.49.172.244";
 Pattern pattern=Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
Matcher matcher = pattern.matcher(data);  
        if (matcher.find()) {  
            System.out.println(matcher.group());  
        }