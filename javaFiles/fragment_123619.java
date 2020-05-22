public class DistinctSongResultTransformer implements ResultTransformer {
    private ResultTransformer defaultTransformer = Criteria.DISTINCT_ROOT_ENTITY;

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        return defaultTransformer.transformTuple(tuple, aliases);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List transformList(List collection) {
        Map<Integer, Song> distinctSongs = new LinkedHashMap<>();
        for (Object object : collection) {
            Song song = (Song) object;
            distinctSongs.putIfAbsent(song.getId(), song);
        }
        return new ArrayList<>(distinctSongs.values());
    }
}