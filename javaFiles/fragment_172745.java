private static String[] readDataUsingJava8() {
        String[] transformedNames = null;
        try (Stream<String> stream = Files.lines(Paths.get( "/Users/kuma/Desktop/post1.txt"))) {
            transformedNames =
             stream.map(new Function<String, String>() {

                @Override
                public String apply(String t) {
                    // TODO Auto-generated method stub
                    return t.replace(" ", "--");
                }
            }).toArray(String[]::new);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return transformedNames;
    }