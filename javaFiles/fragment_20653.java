String input = "ACCATGCCCTAGTTT";
    String expected = "ATGCCCTAG";

    Pattern pattern = Pattern.compile("(ATG)(.{3})*?(TAG|TGA|TAA)",
            Pattern.CASE_INSENSITIVE);
    Matcher m = pattern.matcher(input);
    while (m.find()) {
        System.out.printf("[%d] %s%n", m.start(), m.group());
    }