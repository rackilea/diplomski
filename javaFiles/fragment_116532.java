Collections.sort(result, new Comparator<Map<String, Object>>() {

    @Override
    public int compare(Map<String, Object> o1, Map<String, Object> o2) {
        return Integer.compare(getMapScore(o1), getMapScore(o2));
    }

    private int getMapScore(Map<String, Object> map) {
        final String color = ((String) map.get("color")).toLowerCase();
        switch (color) {
            case "red":
                return 0;
            case "blue":
                return 1;
        }
        return 2;
    }
});