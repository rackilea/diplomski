Set<Person> findAllByAddresses_ZipCodeInAndZipCodeIn(Set<String> zip1, Set<String> zip2);

public @ResponseBody Iterable<Person> personsWithBothZipCodes(@PathVariable("zip1") String zip1, @PathVariable("zip2") String zip2) {

    Set<String> zipSet1 = new HashSet<>();
    zipSet1.add(zip1);

    Set<String> zipSet2 = new HashSet<>();
    zipSet2.add(zip2);

    Set<Person> a = personRepository.findAllByAddresses_ZipCodeInAndZipCodeIn(zipSet1, zipSet2);

    return a;
}