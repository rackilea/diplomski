Pipeline pipeline = Pipeline.create(options);

    pipeline.apply("Read from BQ", BigQueryIO.readTableRows().from(inputTable))
            .apply("Transform to row", ParDo.of(new RowParDo())).setRowSchema(SCHEMA)
            .apply("Set first level key", WithKeys.of(new GroupKey(key1)))
            .apply("Group by", GroupByKey.create())
            .apply("to leaf nodes", ParDo.of(new ToLeafNode()))
            .apply("Set 2nd level key", WithKeys.of(new GroupKey2()))
            .apply("Group by 2nd level", GroupByKey.create())
            .apply("To tree nodes", ParDo.of(new ToTreeNode())).setCoder(SerializableCoder.of(TreeNode.class))
            .apply("Top N", Top.of(10, new CompareTreeNode<TreeNode>()))
            .apply("Flatten", FlatMapElements.via(new FlattenNodes<TreeNode>()))
            .apply("Expand", ParDo.of(new ExpandTreeNode()))
            .apply("Top N of first key", Top.perKey(10, new CompareTreeNode<LeafNode>()))
            .apply("Values", Values.create())
            .apply("Flatten", FlatMapElements.via(new FlattenNodes<LeafNode>()))
            .apply("Expand", ParDo.of(new ExpandLeafNode()))
            .apply("Values", Values.create())
            .apply("Write to bq",
                    BigQueryIO.<Row>write().to(outputTable).withSchema(BigQueryUtils.toTableSchema(SCHEMA))
                            .withWriteDisposition(WriteDisposition.WRITE_TRUNCATE)
                            .withCreateDisposition(CreateDisposition.CREATE_IF_NEEDED)
                            .withFormatFunction(BigQueryUtils.toTableRow()));
    pipeline.run();