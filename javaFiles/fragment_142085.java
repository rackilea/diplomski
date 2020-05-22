public static ArrayList<String> getBinaries(int bits, String current) {
    ArrayList<String> binaries = new ArrayList<>();

    if (current.length() == bits) {
        binaries.add(current);
        return binaries;
    }

    //pad a 0 and 1 in front of current;
    binaries.addAll(getBinaries(bits, "0" + current));
    binaries.addAll(getBinaries(bits, "1" + current));

    return binaries;
}