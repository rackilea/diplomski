private void CreateCombinations(List<Focus> focuses, int index, string[] values) {
    Focus focus = focuses.get(index);
    for (string v : focus.values) {
        values[index] = v;
        if (index < focuses.size() - 1) {
            // there is at least one other focus
            CreateCombinations(focuses, index+1, values);
        } else {
            // all values pinned down
            StringBuilder sb = new StringBuilder(values[0]);
            for (int i = 1; i < values.length; ++i) {
                sb.append(" ").append(values[i]);
            }
            // now do whatever you like to do with sb.toString()...
        }
    }
}