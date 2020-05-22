public static Map<String, String> getSchoolAndTeacherFrom(Country country, Predicate<School> schoolWithModelAndTeacher) {
    return country.getCities().values().stream()
            .flatMap(city -> city.getSchools().values().stream())
            .filter(schoolWithModelAndTeacher::test)
            .collect(Collectors.toMap(School::getName, school -> school.getModel().getTeacher().getId()));
}