public @ResponseBody Iterable<Person> personsWithBothZipCodes(@PathVariable("zip1") String zip1, @PathVariable("zip2") String zip2) {

    Set<String> zipSet = new HashSet<>();
    zipSet.add(zip1);
    zipSet.add(zip2);

    Set<Person> a = personRepository.findAllByAddresses_ZipCodeIn(zipSet);

    return a;
}