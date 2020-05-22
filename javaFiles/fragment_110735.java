function write_tree (top_node) {
    if is_leaf(top_node) {
        write "0"
        // optionally, write any date associated with the leaf node
        // although in practice it's easier to write the leaf data
        // to a separate output stream. That lets this stream contain
        // actual bits rather than the characters "0"/"1"
        }
    else {
        write "1"
        write_tree (top_node.left)
        write_tree (top_node.right) }}

function read_tree (bit_stream) -> returns tree
    next_bit = bit_stream.read()
    if next_bit = "0" {
        root = new leaf
        // optionally read data associated with the leaf node
        }
    else {
        root = new internal node
        root.left = read_tree (bit_stream)
        root.right = read_tree (bit_stream) }
    return root }