input = input.replaceAll(".{3}", "$0,");

    Pattern pattern = Pattern.compile("(ATG,)(.{4})*?(TAG|TGA|TAA),",
            Pattern.CASE_INSENSITIVE);
    Matcher m = pattern.matcher(input);
    while (m.find()) {
        System.out.printf("[%d] %s%n", m.start() * 3 / 4, m.group().replace(",", ""));
    }