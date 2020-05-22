static String assignRoundRobin(int... quotas) {
    StringJoiner sj = new StringJoiner(",");
    for (int remain = 1; remain > 0; ) {
        remain = 0;
        for (int i = 0; i < quotas.length; i++) {
            if (quotas[i] > 0) {
                sj.add(String.valueOf((char) ('A' + i)));
                remain += --quotas[i];
            }
        }
    }
    return sj.toString();
}