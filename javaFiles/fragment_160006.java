public boolean addMember(Member m) {
    boolean result = false;

    for (int i = 0; i < members.length; i++) {
        if (members[i] == null) {
            members[i] = m;
            result = true;
            break;
        }
    }

    return result;
}