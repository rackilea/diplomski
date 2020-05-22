private static List<String> simplify(Iterable<String> elms) {
        List<String> result = new ArrayList<>();
outer:
        for (String elm: elms) {
            int i = 0;
            while (i < result.size()) {
                String relm = result.get(i);
                if (relm.contains(elm)) {
                    continue outer;
                } else if (elm.contains(relm)) {
                    result.remove(i);
                } else {
                    ++i;
                }
            }
            result.add(elm);
        }
        return result;
    }