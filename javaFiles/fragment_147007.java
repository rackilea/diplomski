package com.ggl.testing;

public class RemoveSubstrings {

    public static void main(String[] args) {
        String example = "year, year - 1970, year - 1980, event, "
                + "event - launch, event - stop, event - stop - final, "
                + "1970 - year";
        System.out.println(example);
        System.out.println(substring(example));
    }

    public static String substring(String s) {
        String[] parts = s.split(", ");
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            boolean unique = true;
            for (int j = i + 1; j < parts.length; j++) {
                if (parts[j].startsWith(parts[i])) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                builder.append(parts[i]);
                builder.append(", ");
            }
        }

        if (builder.length() > 2) {
            return builder.substring(0, builder.length() - 2).toString();
        }

        return builder.toString();
    }

}