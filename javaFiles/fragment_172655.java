HashMap<Integer, Set<Anime>> animeMap = new HashMap<>();
for(Anime anime : animius.getListOfAnime){

    int numberOfEpisodes = anime.getListOEpisodes().size(); 
    if (animeMap.contains(numberOfEpisodes) {
      animeMap.get(numberOfEpisodes).add(anime);
    } else {
      HashSet<Anime> animeNames = new HashSet<>();
      animeNames.add(anime);
      animeMap.put(numberOfEpisodes, animeNames);
    }

}