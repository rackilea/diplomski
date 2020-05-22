String input = "Hello world my # is 123 mail me @ test@test.com";
String EMAIL_PATTERN = "([^.@\\s]+)(\\.[^.@\\s]+)*@([^.@\\s]+\\.)+([^.@\\s]+)";

String output = input.replaceAll(EMAIL_PATTERN, "") // Replace emails 
                                                    // by an empty string
        .replaceAll("\\p{Punct}", "") // Replace all punctuation. One of
                                      // !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
        .replaceAll("\\d", "") // Replace any digit by an empty string
        .replaceAll("\\p{Blank}{2,}+", " "); // Replace any Blank (a  space or 
                                             // a tab) repeated more than once
                                             // by a single space.

System.out.println(output);