private void handleLeaf(Leaf leaf) {
    if(leaf instanceof AppleLeaf)
        handleLeaf((AppleLeaf)leaf);
    else if(leaf instanceof MangoLeaf)
        handleLeaf((MangoLeaf)leaf);
    ...//And so on
}