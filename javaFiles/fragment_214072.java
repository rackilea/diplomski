Map<Boolean, List<String>> map = Files.lines(filePath)
        .filter(str -> urlPattern.matcher(str).matches() ||
                       emailPattern.matcher(str).matches())
        .distinct()
        .collect(Collectors.partitioningBy(str -> urlPattern.matcher(str).matches()));
List<String> urls = map.get(true);
List<String> emails = map.get(false);