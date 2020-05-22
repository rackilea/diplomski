private static final class RootDto {

    @SerializedName("Tree")
    @SuppressWarnings("unused")
    private final TreeDto tree;

    private RootDto(final TreeDto tree) {
        this.tree = tree;
    }

}

private static final class TreeDto {

    @SerializedName("rootNodeId")
    @SuppressWarnings("unused")
    private final String rootNodeId;

    @SerializedName("allNodes")
    @SuppressWarnings("unused")
    private final List<NodeDto> allNodes;

    private TreeDto(final String rootNodeId, final List<NodeDto> allNodes) {
        this.rootNodeId = rootNodeId;
        this.allNodes = allNodes;
    }

}

private abstract static class NodeDto {
}

private static final class Node1Dto
        extends NodeDto {

    @SerializedName("id")
    @SuppressWarnings("unused")
    private final String id;

    @SerializedName("node2Id")
    @SuppressWarnings("unused")
    private final String node2Id;

    private Node1Dto(final String id, final String node2Id) {
        this.id = id;
        this.node2Id = node2Id;
    }

}

private static final class Node2Dto
        extends NodeDto {

    @SerializedName("id")
    @SuppressWarnings("unused")
    private final String id;

    private Node2Dto(final String id) {
        this.id = id;
    }

}