@ResponseBody
public Collection<Interest> getPersonByName(@PathVariable String name) {
    String regex = "(?i).*" + name + ".*";
    Set<Interest> interests = interestRepository.getKindOf(regex);
    return interests;
}