int node = e;
while (node != s) {
    shortest.add(0, node);
    node = back[node];
}
shortest.add(0, s);