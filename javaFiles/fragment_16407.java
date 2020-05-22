private TreeModel<ExampleEntity> tree;

@PostConstruct
public void init() {
    tree = new ListTreeModel<ExampleEntity>();
    tree.addChild(new ExampleEntity(1L, "One"))
            .addChild(new ExampleEntity(2L, "Two")).getParent()
            .addChild(new ExampleEntity(3L, "Three")).getParent()
            .getParent()
        .addChild(new ExampleEntity(4L, "Four"))
            .addChild(new ExampleEntity(5L, "Five"));
}