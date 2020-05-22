final Pattern pattern = Pattern.compile("\\bKey=Value\\b(?:(?!EndOfEntry).)*?\\bAnotherKey=AnotherValue\\b", Pattern.DOTALL);

final String invalid = "unimportant text\n" +
                "EndOfEntry\n" +
                "Key=Value\n" +
                "unimportant text\n" +
                "maybe a few lines of unimportant text\n" +
                "AnotherKey=NotMyValue\n" +
                "EndOfEntry\n" +
                "RandomKey=Value\n" +
                "unimportant text\n" +
                "maybe a few lines of unimportant text\n" +
                "AnotherKey=AnotherValue\n" +
                "EndOfEntry\n" +
                "more unimportant text";

final String valid = "unimportant text\n" +
                "EndOfEntry\n" +
                "Key=Value\n" +
                "unimportant text\n" +
                "maybe a few lines of unimportant text\n" +
                "AnotherKey=AnotherValue\n" +
                "EndOfEntry\n" +
                "more unimportant text";

System.out.println(pattern.matcher(invalid).find());
System.out.println(pattern.matcher(valid).find());