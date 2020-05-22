Arrays.stream(strs)
        .collect(Collectors.groupingBy(str -> {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
        }));