public interface Spacer {

    public SpacerField getSpacer(int resolution);

}

public class MySpacer implements Spacer {

    private Map<Integer, Integer> spacerSize;

    public MySpacer(Map spacerSize<Integer, Integer>) {
        this.spacerSize = spacerSize;
    }

    public SpacerField getSpacer(int resolution) {
        Integer size = spacerSize.get(resolution);
        if (size == null) {
            throw new IllegalArgumentException("Invalid resolution: " 
                            + resolution);
        }
        return new SpacerField(size);
    }

}