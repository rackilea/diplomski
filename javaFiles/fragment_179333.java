public static ArrayList<String> parseDocument(
        final String document,
        final String begin,
        final String end) {

    ArrayList<String> subs = new ArrayList<String>(0);

    document_parse:
        for (int i = 0, h, j, k; i < document.length(); ) {

            for (h = i, k = 0; k < begin.length(); h++, k++) {
                if (h > document.length() - begin.length()) {
                    break document_parse;

                } else if (document.charAt(h) != begin.charAt(k)) {
                    i++;
                    continue document_parse;
                }
            }

            end_search:
                for ( ; ; h++) {
                    if (h > document.length() - end.length()) {
                        break document_parse;
                    }

                    for (j = h, k = 0; k < end.length(); j++, k++) {
                        if (document.charAt(j) != end.charAt(k)) {
                            continue end_search;
                        }
                    }

                    if (k == end.length()) {
                        break;
                    }
                }

            h += end.length();

            subs.add(document.substring(i, h));

            i = h;
        }

    return subs;
}