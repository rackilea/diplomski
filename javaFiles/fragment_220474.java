public class Branch extends Composite implements Embeddable {
    EmbeddableDelegate delegate;
}

public class Leaf implements Embeddable {
    EmbeddableDelegate delegate;
}

public class EmbeddableDelegate [implements Embeddable] {
    private short xOffset, yOffset, zOffset;
    private Container parent;