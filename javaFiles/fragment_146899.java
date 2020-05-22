Runner runner = new Runner(ShortestPathAlgorithm.class)
                        .execute("show")
                        .withParameter(int[][].class, graph)
                        .withParameter(int.class, from)
                        .withParameter(int.class, des);
runner.run();