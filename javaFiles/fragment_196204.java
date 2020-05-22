private static boolean check(Set cache, String ref, String ip, String ue, String mail) {
    return Sets.powerSet(ImmutableSet.of(0, 1, 2, 3)).stream().map(set -> {
        BlacklistKey key = new BlacklistKey("*", "*", "*", "*");
        for (Integer idx : set) {
            switch (idx) {
                case 0:
                    key.setReferrer(ref);
                    break;
                case 1:
                    key.setIp(ip);
                    break;
                case 2:
                    key.setUserAgent(ue);
                    break;
                case 3:
                    key.setEmail(mail);
            }
        }
        return key;
    }).anyMatch(keys::contains);
}