public int totalKinds() {
        List<String> unique = new ArrayList<>();
        for (int i = 0; i < acts.length; i++) {
            if (!unique.contains(acts[i]))
                unique.add(acts[i].getKind());   
        }
        return unique.size();
    }