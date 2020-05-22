int eval(tree) {
    if tree is just a number return that number
    else {
        l = eval(tree.left)
        r = eval(tree.right)
        return result of operation on l and r
    }
}