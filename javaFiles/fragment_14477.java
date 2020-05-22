KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
                try {
                    kbuilder.add(ResourceFactory.newInputStreamResource(new FileInputStream(new File("C:/IotHub/conf/"+deviceID))), ResourceType.DRL );
                } catch (FileNotFoundException e) {
                }
                KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
                kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );
               // 
               StatelessKnowledgeSession  ksession = kbase.newStatelessKnowledgeSession();

                ksession.execute(bean);