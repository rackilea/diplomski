g.V().has("Entity","uuid","6708ec6d-4518-4159-9005-9e9d642f157e")
        .project("entity","types").by().by(outE("IsOfType").fold())
        .forEachRemaining(m -> {
            final Vertex entityV = (Vertex) m.get("entity");
            final List<Edge> typeE = (List<Edge>) m.get("types");
            // whatever ...
        })