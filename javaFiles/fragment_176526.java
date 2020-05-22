List<String> args = new ArrayList<String>();
    while (true) {
        try {
            args.add(processFile(i++));
        }
        catch (Exception e) {
            // your code
        }
    }
    String[] array = args.toArray(new String[0]);