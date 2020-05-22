String programNumber = "3";
// create the result list (empty initially)
List<Map<String, String>> episodesForProgramNumber = new ArrayList<>();

// loop through all the episodes
for (Map<String, String> episode : allEpisodes) {

    // if the current episode has the given program number, add it to the result
    if (programNumber.equals(episode.get("pN")) {
        episodesForProgramNumber.add(episode);
    }
}