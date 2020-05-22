//Then use them when needed...
    for (Map.Entry<String,String> entry : argsMap.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        System.out.println("arg: "+ key + "\tval:" + value);

        switch (key) {
            case "runType":
                //Add your business logic here
                break;
            case "threadCnt":
                //Add your business logic here
                break;
            case "cleanLogs":
                //Add your business logic here
                break;
            default:
                //Unknown argument
                throw new RuntimeException("Invalid argument!");
        }
    }