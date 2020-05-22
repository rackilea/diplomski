Iterable<Vertex> result2=g.getVerticesOfClass("Person");
            for(Vertex v:result2){  
                String rid=v.getId().toString();
                String name=v.getProperty("name");
                String surname=v.getProperty("surname");
                System.out.println(rid + " " + name + " " + surname);  
            }