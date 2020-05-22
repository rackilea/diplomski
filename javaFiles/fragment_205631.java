function toArrayLevels(node)
{
    var temporary = []; // Temporary is used for level-order traversal.

    var tree = []; // Levels containing their nodes.
    var nodes = []; // Current level containing its nodes.

    var current = node; // Level 0.
    var level = 1; // Node's children are level 1.

    temporary.push(current);
    tree.push([current]);

    while (temporary.length > 0)
    {
        // When the nodes completely fill the maximum spaces (2 ^ level) allowed on the current level, start the next level.
        if (nodes.length >= Math.pow(2, level))
        {
            tree.push(nodes);
            nodes = [];
            level += 1;
        }

        current = temporary.shift();

        // Check current's children.
        if (current !== null)
        {
            var left = current.left;
            var right = current.right;

            temporary.push(left);
            nodes.push(left);

            temporary.push(right);
            nodes.push(right);
        }
        else
        {
            // Null nodes fill spaces used to maintain the structural alignment of the tree.
            nodes.push(null);
            nodes.push(null);
        }
    }

    // Push remaining nodes.
    if (nodes.length > 0)
    {
        tree.push(nodes);
    }

    return tree;
}