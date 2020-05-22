@Test
                public void testDomain() {
                    Application foo = new Application("Foo");
                    Version foo10 = new Version("1.0"); //create a NEW version
                    Version foo11 = new Version("1.1"); //create a NEW version
                    Version foo20 = new Version("2.0"); //create a NEW version
                    foo.addVersion(foo10);
                    foo.addVersion(foo11);
                    foo.addVersion(foo20);
                    applicationRepository.save(foo);

                    Application bar = new Application("Bar");
                    Version bar10 = new Version("1.0"); //create a NEW version
                    Version bar20 = new Version("2.0"); //create a NEW version
                    Version bar30 = new Version("3.0"); //create a NEW version
                    bar.addVersion(bar10);
                    bar.addVersion(bar20);
                    bar.addVersion(bar30);
                    applicationRepository.save(bar);

                    session.clear();

                    assertEquals(2, applicationRepository.count()); //2 apps
                    assertEquals(6, versionRepository.count()); //6 versions

                    session.clear();

                    Application barWithoutVersionsLoaded = 
applicationRepository.findOne(bar.getId(),0); 

       //Depth=0 will only load the application and properties on the application node 
       //but not its related objects. 
       //If you don't specify depth, it defaults to 1
                    assertEquals("Bar", barWithoutVersionsLoaded.getName());
                    assertEquals(0, barWithoutVersionsLoaded.getVersions().size()); //No versions loaded

                }