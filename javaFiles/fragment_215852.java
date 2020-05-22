@Override
public int compareTo(Reviews r) {
    int result = this.score.compareTo(r.score);
    if (result != 0) return result;
    result = this.pos.compareTo(r.pos);
}