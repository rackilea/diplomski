func bestChild() -> Node? {
    var max = Int.min
    var maxNode: Node?

    for child in children {
        if max < child.value {
            max = child.value
            maxNode = child
        }
    }

    return maxNode
}