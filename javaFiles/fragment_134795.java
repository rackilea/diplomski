Factory<Integer> vertexFactory = 
            new Factory<Integer>() {
                int count;
                public Integer create() {
                    return count++;
            }};