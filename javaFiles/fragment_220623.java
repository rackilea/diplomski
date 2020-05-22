@NodeEntity
class Point {
    @GraphId
    protected Long id;

    @RelatedToVia(type="NEXT")
    Set<Edge> edges;
}

@NodeEntity
class Line {
    @GraphId
    protected Long id;

    @RelatedTo(type="ROOT")
    Point root;
}

@RelationshipEntity
public class Edge  {
    @GraphId
    protected Long id;

    @StartNode private Point from;
    @EndNode private Point to;

    @RelatedTo(type="LINE")
    Line line;
}