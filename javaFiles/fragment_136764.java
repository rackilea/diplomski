public class GivenUUIDGenerator {
    public static GivenUUIDGenerator with(List<String> playbackUUIDs) {
        return new GivenUUIDGenerator(playbackUUIDs);
    }

    private final ImmutableList<String> playbackUUIDs;

    private GivenUUIDGenerator(List<String> playbackUUIDs) {
        this.playbackUUIDs = ImmutableList.copyOf(playbackUUIDs);
    }

    public GivenUUIDGenerator and(String uuid){
        return new GivenUUIDGenerator(ImmutableList.<String>builder().addAll(playbackUUIDs).add(uuid).build());
    }

    public ... generate() {
        // ... do here whatever it is you want to do with your list
    }
}