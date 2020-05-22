long start = System.currentTimeMillis();
        ObjectMapper mapper  = new ObjectMapper();
        ArrayList<Obsidian> results = new ArrayList<Obsidian>();
        for (Obsidian obs : obsidianRepo.findByOrder(order)) {
            results.add(obs);
            mapper.writeValueAsString(obs);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);