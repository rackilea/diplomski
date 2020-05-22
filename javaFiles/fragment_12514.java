private void movePerson(Person p, int[] dest) {
    int[] pos = p.getPos();
    pmap[pos[0]][pos[1]].remove(p);
    pmap[dest[0]][dest[1]].add(p);
    p.setPos(dest[0], dest[1]);
}