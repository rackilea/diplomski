// parse the duration manually
String[] parts = "00:01:07".split(":");
Duration d = Duration
    // get hours
    .ofHours(Long.parseLong(parts[0]))
    // plus minutes
    .plusMinutes(Long.parseLong(parts[1]))
    // plus seconds
    .plusSeconds(Long.parseLong(parts[2]));