public static void main(String[] args){
        Pattern p = Pattern.compile("[^\\s']*ClassLoader[^\\s']*");
        Matcher m = p.matcher("2014-05-21 22:05:13.685 TRACE [Core] sun.misc.Launcher$AppClassLoader@62c8aeb3 searching for resource 'java/util/LoggerFactory.class'.");
        if (m.find()) {
            System.out.println(m.group());
        }
    }