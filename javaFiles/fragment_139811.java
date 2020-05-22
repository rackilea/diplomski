String template = "Computer programming, also known as [-ing Verb], is a\n" +
                  "process that leads from a [Adjective] problem\n" +
                  "to an executable [Noun].\n" +
                  "Programming often involves [-ing Verb],\n" +
                  "[-ing Verb], and [-ing Verb], and can be learned\n" +
                  "by anyone!\n" +
                  "Source code is written in a programming language,\n" +
                  "such as [Animal]code, or Java.\n" +
                  "The first ever programmer was [Name of Celebrity],\n" +
                  "who invented [Plural Noun] in the year [Year].\n" +
                  "Since then, programming has become a\n" +
                  "[Adjective] practice all across the world.";
List<String> placeholders = Arrays.asList(
        "[-ing Verb]", "[Adjective]", "[Noun]",
        "[-ing Verb]", "[-ing Verb]", "[-ing Verb]",
        "[Animal]", "[Name of Celebrity]", "[Plural Noun]",
        "[Year]", "[Adjective]" );
List<String> replacements = Arrays.asList(
        "AA", "BB", "CC",
        "DD", "EE", "FF",
        "GG", "HH", "II",
        "JJ", "KK" );
String result = replacePlaceHolder(template, placeholders, replacements);
System.out.println(result);