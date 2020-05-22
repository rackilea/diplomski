public void saveMenu(int type, int budget, int date, List<Integer> preferences) {
     ...
     int offset = 4; // 1 = type, 2 = budget, 3 = date, 4 = first prefence
     for(int i = 0; i < 5; ++i) {
        if(i < preferences.size()) {
            ps.setLong(i + offset, preferences.get(i));
        } else {
            ps.setLong(i + offset, 0L);
        }
     }
}