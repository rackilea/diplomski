class Top {
}
class Middle extends Top implements Comparable<Top> {
    @Override
    public int compareTo(Top o) {
        // 
    }
}
class Bottom extends Middle {
}