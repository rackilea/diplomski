public int getMaxData(Node d) {
    if (d.data > max)
        max = d.data;
    if (d.nextNode != null)
        return getMaxData(d.nextNode);
    return max;
}