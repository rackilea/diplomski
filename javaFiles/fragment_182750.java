if (pass[i] == false && matrix[node][i] == 1) {
    pass[i] = true;
    paths.add(0,i);

    // Add this:
    back[i] = node;
}