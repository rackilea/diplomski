Calendar end = new GregorianCalendar(TimeZone.getDefault());
    end.add(Calendar.MONTH, 1);

    List<Calendar> satsAndSuns = new ArrayList<>(200);
    // start 1 year 6 months before today
    Calendar current = new GregorianCalendar(TimeZone.getDefault());
    current.add(Calendar.YEAR, -1);
    current.add(Calendar.MONTH, -6);
    if (current.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        // we need to add a copy because we will continue to modify current
        // I really don’t like using clone(), but it’s the simplest way
        satsAndSuns.add((Calendar) current.clone());
    }
    // Set current to next saturday
    // This is where Calendar is not so straightforward as ZonedDateTime
    // Subtraction of day of week works because in Calendar, Saturday is the last day of the week
    current.add(Calendar.DATE, Calendar.SATURDAY - current.get(Calendar.DAY_OF_WEEK));
    assert current.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
    while (! current.after(end)) {
        satsAndSuns.add((Calendar) current.clone());
        current.add(Calendar.DATE, 1);
        assert current.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
        if (current.after(end)) {
            break;
        }
        satsAndSuns.add((Calendar) current.clone());
        current.add(Calendar.DATE, 6);
        assert current.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
    }
    Calendar[] selecatbleDays = satsAndSuns.toArray(new Calendar[satsAndSuns.size()]);