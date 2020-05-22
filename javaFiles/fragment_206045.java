class Node {
    let value = 0
    let children = [Node]()
    weak var parent: Node? // Unused?

    func bestChild() -> Node? {
        return children.max(by: { $0.value < $1.value })
    }
}