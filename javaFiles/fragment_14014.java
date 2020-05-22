//features.add(builder.buildFeature(null));
                //System.out.println("ignored");
                //add
                System.out.println("adding...");
                SimpleFeature feature = builder.buildFeature(null);
                ((Collection<SimpleFeature>) features).add(feature);