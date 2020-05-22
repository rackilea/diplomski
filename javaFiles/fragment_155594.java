if (right == null) {
    return parent;
}

if (parent == null) {
    return right;
}

return parent.val > right.val ? right : parent;