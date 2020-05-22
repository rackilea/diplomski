Map<Long, String> map = new HashMap<>();
        Files.lines(Paths.get("full-path-to-your-file")).forEach(line -> {
            String[] arr = line.split(" ");
            Long number = Long.parseLong(arr[0]);
            String string = arr[1];
            map.put(number, string);
        });