for (String x : list) {
    for (String y : input.split(" ")) {
        if (x.contains(y)) return true;
    }
}
return false;