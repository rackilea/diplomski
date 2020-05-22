public int totalKinds() {
        Set<String> unique = new HashSet<>();
        for (Act a: acts) {
            unique.add(a.getKind());
        }
        return unique.size();
    }