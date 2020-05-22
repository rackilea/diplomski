public int totalKinds() {
        long count = Arrays.asList(acts).stream()
                .map(act -> act.getKind())
                .distinct()
                .count();
        return Math.toIntExact(count);
    }