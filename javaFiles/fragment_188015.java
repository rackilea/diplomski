private static void permute(String[] ss, boolean[] used,
                            String res, int level, List<String> list) {

    // End case
    if (level == ss.length && res != ""){
        list.add(res);
        return;
    }

    for (int i = 0; i < ss.length; i++) {
        // Check if the string is currently used
        if (used[i]) {
            continue;
        }
        // Check if res is empty or a single word
        if(level > 1)
            list.add(res);
        used[i] = true;
        permute(ss, used, res + " " + ss[i], level + 1, list);
        used[i] = false;
    }
}