private static final Comparator<Articles_Map> byPublishedAtComparator =
        new Comparator<Articles_Map>() {
            @Override
            public int compare(Articles_Map o1, Articles_Map o2) {
                // needs further testing in case of nulls
                if (o1.publishedAt == null) {
                    return (o2.publishedAt == null) ? 0 : -1;
                } else if (o2.publishedAt == null) {
                    return 1;
                }

                return o1.publishedAt.compareTo(o2.publishedAt);
            }
        };