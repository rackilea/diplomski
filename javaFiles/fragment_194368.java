PomEquippedResolveStage pomEquippedResolveStage = Maven.resolver().loadPomFromFile("pom.xml");

        File[] hibernateLibs = pomEquippedResolveStage.resolve(
                "org.hibernate:hibernate-entitymanager"
                 ).withTransitivity().asFile(); 
 final WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addAsLibraries(hibernateLibs)                
             .addClass(org.hibernate.tool.schema.internal.SchemaDropperImpl.class)