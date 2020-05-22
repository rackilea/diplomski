public static Map<String, String> getSchoolAndTeacherFrom(Country country, Predicate<School> schoolWithModelAndTeacher) {
    return country.getCities().values().stream()
            .flatMap(c -> c.getSchools().entrySet().stream())
            .filter(s -> schoolWithModelAndTeacher.test(s.getValue()))
            .collect(Collectors.toMap(Entry::getKey, schoolEntry -> schoolEntry.getValue().getModel().getTeacher().getId()));
}