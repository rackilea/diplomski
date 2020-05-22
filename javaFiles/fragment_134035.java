public static String concatListOfStrings(String separator, Iterable<String> strings) {
        StringBuilder sb = new StringBuilder();

        for (String str : strings) {
            sb.append(separator).append(str);
        }

        sb.delete(0, separator.length());

        return sb.toString();
    }
}