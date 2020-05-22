/**
 * Find components of Caramel : tests that level 1 relationship works
 */
@Test
public void testCaramelContainsSugar() {
    try (Transaction ignored = graphDb.beginTx()) {

        Node n = null;
        TraversalDescription traversalDescription = graphDb.traversalDescription()
                .breadthFirst()
                .relationships(FoodRelationshipType.CONTAINS, Direction.OUTGOING)
                .evaluator(Evaluators.excludeStartPosition());

        Traverser traverser = traversalDescription.traverse(
                getSingleNode(LabelType.COOKED_MEAL, PropertyType.NAME.getName(), "Caramel")
        );

        List<Node> endNodes = new ArrayList<>();
        for (Path path : traverser) {
            endNodes.add(path.endNode());
        }

        Assert.assertTrue(endNodes.contains(getSingleNode(LabelType.RAW_MATERIAL, PropertyType.NAME.getName(), "Sugar")));
    }
}