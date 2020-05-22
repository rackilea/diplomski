String [] properties = {"name"};
        String [] value = {"pluto"};

        Iterable<Vertex> i_ad = g.getVertices("Animal", properties, value);
        for(Vertex v:i_ad){ 
            System.out.println(v.getProperty("name").toString());
        }