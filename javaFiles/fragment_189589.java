LocalTime begin1 = LocalTime.of(1, 0);
    LocalTime end1 = LocalTime.of(3, 0);
    LocalTime begin2 = LocalTime.of(13, 45);
    LocalTime end2 = LocalTime.of(14, 45);

    // Convert interval 1 to AM
    if (begin1.get(ChronoField.AMPM_OF_DAY) == 1) { // PM
        begin1 = begin1.minusHours(12);
        end1 = end1.minusHours(12);
    }
    // validate
    if (end1.isBefore(begin1)) {
        throw new IllegalStateException("end1 " + end1 + " must not be before begin1 " + begin1);
    }
    if (end1.isAfter(LocalTime.NOON)) {
        throw new IllegalStateException("Interval 1 must be completely within either AM or PM");
    }

    // Convert interval 2 to AM
    if (begin2.get(ChronoField.AMPM_OF_DAY) == 1) {
        begin2 = begin2.minusHours(12);
        end2 = end2.minusHours(12);
    }
    // validate
    if (end2.isBefore(begin2)) {
        throw new IllegalStateException("end2 " + end2 + " must not be before begin2 " + begin2);
    }
    if (end2.isAfter(LocalTime.NOON)) {
        throw new IllegalStateException("Interval 2 must be completely within either AM or PM");
    }

    if (end2.isAfter(begin1) && end1.isAfter(begin2)) {
        System.out.println("They overlap");
    } else {
        System.out.println("They do not overlap");
    }