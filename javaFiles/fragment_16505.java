Map<String, String> envMap = System.getenv();

    Iterator iter = envMap.entrySet().iterator();

    while (iter.hasNext()) {
        Map.Entry<String, String> pair = (Map.Entry<String, String>)iter.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
    }