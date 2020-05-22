public boolean addMember(Member m) {
    for (int i = 0; i < members.length; i++) {
        if (members[i] == null) {
            members[i] = m;
            return true;
        }
    }

    return false;
}