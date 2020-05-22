for (String id : allIds) {
    String[] teamIds = list.parallelStream()
                           .filter(row -> row.getId().equals(id))
                           .map(ViewData::getTeamId).distinct()
                           .toArray(String[]::new);

    teamIds = Arrays.copyOf(teamIds, teamIds.length + 1);
    teamIds[teamIds.length - 1] = list.parallelStream()
                                      .filter(obj -> obj.getId().equals(id))
                                      .map(ViewData::getManagerId)
                                      .findFirst()
                                      .orElse(null);

    System.out.println(teamIds.length + "\n");
}