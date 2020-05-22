ZoneId zone = ZoneId.systemDefault();
    ZonedDateTime agoZdt = ago.atZone(zone);
    ZonedDateTime nowZdt = now.atZone(zone);
    this.years = ChronoUnit.YEARS.between(agoZdt, nowZdt);
    ZonedDateTime afterWholeYears = agoZdt.plusYears(this.years);

    Duration dur = Duration.between(afterWholeYears, nowZdt);

    this.seconds = dur.toSecondsPart(); // 40
    this.minutes = dur.toMinutesPart(); // 41
    this.hours = dur.toHoursPart(); // 1
    this.days = dur.toDays(); // 0