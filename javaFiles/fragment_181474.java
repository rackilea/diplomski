public ResponseEntity<List<String>> getUsersByMission(@PathVariable("missionId") String missionId) {
    final Optional<Mission> mission = this.missionResource.findById(missionId);

    if (mission.isEmpty()) {
       // Handle the "mission not found" case
    }

    final List<String> names = 
                  mission.get().getUsers()
                               .stream()
                               .map(user -> user.getNameUser())
                               .collect(Collectors.toList());

    return ResponseEntity.ok().body(names);
}