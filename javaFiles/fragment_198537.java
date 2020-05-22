Settings settings;

// Add this
settings = new Settings().withRenderSchema(false);

// Or this
settings = new Settings().withRenderMapping(
    new RenderMapping().withSchemata(
        new MappedSchema().withInput("db_dev").withOutput("db_prod")));
DSLContext ctx = DSL.using(connection, MYSQL, settings);
ctx.select().from(...).fetch();