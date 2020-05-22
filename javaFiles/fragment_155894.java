Content c = contentList
            .stream()
            .reduce((t, u) -> new Content(
                                  t.getA() + ',' + u.getA(),
                                  t.getB() + ',' + u.getB(), 
                                  t.getC() + ',' + u.getC())
                   ).get();