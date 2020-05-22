public static Predicate hasTimeBeetween(final ZonedDateTime from, final ZonedDateTime to) {

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(QMyDocument.myDocument.remoteTime.after(from));
        builder.and(QMyDocument.myDocument.remoteTime.before(to));

        return builder.getValue();
    }