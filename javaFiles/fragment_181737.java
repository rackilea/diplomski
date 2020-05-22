if (value.contains("+")) {
        value = value.substring(0, value.lastIndexOf("+") - 1);
    }

    String[] patterns = {//"EEE, dd MMM yyyy hh:mm:ss UTC",
            "yyyy.MM.dd G 'at' HH:mm:ss z",
            "EEE, MMM d, ''yy",
            "yyyyy.MMMMM.dd GGG hh:mm aaa",
            "EEE, d MMM yyyy HH:mm:ss Z",
            "yyMMddHHmmssZ",
            "d MMM yyyy HH:mm:ss z",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm:ss'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ssZ",
            "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
            "yyyy-MM-dd'T'HH:mm:ssz",
            "yyyy-MM-dd'T'HH:mm:ss.SSSz",
            "EEE, d MMM yy HH:mm:ssz",
            "EEE, d MMM yy HH:mm:ss",
            "EEE, d MMM yy HH:mm z",
            "EEE, d MMM yy HH:mm Z",
            "EEE, d MMM yyyy HH:mm:ss z",
            "EEE, d MMM yyyy HH:mm:ss Z",
            "EEE, d MMM yyyy HH:mm:ss ZZZZ",
            "EEE, d MMM yyyy HH:mm z",
            "EEE, d MMM yyyy HH:mm Z",
            "d MMM yy HH:mm z",
            "d MMM yy HH:mm:ss z",
            "d MMM yyyy HH:mm z",
            "d MMM yyyy HH:mm:ss z"};

    for (int i = 0; i < patterns.length; i++) {
        SimpleDateFormat sdf = new SimpleDateFormat(patterns[i], Locale.ENGLISH);
        try {
            pubdate = sdf.parse(value);

            break;
        } catch (Exception e) {
        }
    }