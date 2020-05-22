@Override
public int compareTo(Connection o) {
    int orderIndex = LCP_ORDER.indexOf(this.lifecyle)
            - LCP_ORDER.indexOf(o.lifecyle);

    if (orderIndex != 0) {
        return orderIndex;
    }

    int stateIndex = STATE_ORDER.indexOf(this.connEditState)
            - STATE_ORDER.indexOf(o.connEditState);

    return stateIndex;
}