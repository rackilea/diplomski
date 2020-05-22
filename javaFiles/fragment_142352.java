public class Trie
{

    private char blank = '_';

    public Node Root { get; set; }

    public void Insert(String key)
    {
        Root = Insert(Root, key, 0);
    }

    public bool Contains(String key)
    {
        Node x = Find(Root, key, 0);
        return x != null && x.NullNode;
    }

    private Node Find(Node x, String key, int d)
    { // Return value associated with key in the subtrie rooted at x.
        if (x == null)
            return null;

        if (d == key.Length)
        {
            if (x.NullNode)
              return x;
            else
              return null;
        }

        char c = key[d]; // Use dth key char to identify subtrie.

        if (c == blank)
        {
            foreach (var child in x.Children)
            {
                var node = Find(child, key, d + 1);
                if (node != null)
                    return node;
            }

            return null;
        }
        else
            return Find(x.Children[c], key, d + 1);
    }

    private Node Insert(Node x, String key, int d)
    { // Change value associated with key if in subtrie rooted at x.
        if (x == null) x = new Node();
        if (d == key.Length)
        {
            x.NullNode = true;
            return x;
        }

        char c = key[d]; // Use dth key char to identify subtrie.
        x.Children[c] = Insert(x.Children[c], key, d + 1);
        return x;
    }

    public IEnumerable<String> GetAllKeys()
    {
        return GetKeysWithPrefix("");
    }
    public IEnumerable<String> GetKeysWithPrefix(String pre)
    {
        Queue<String> q = new Queue<String>();
        Collect(Find(Root, pre, 0), pre, q);
        return q;
    }

    private void Collect(Node x, String pre, Queue<String> q)
    {
        if (x == null) return;
        if (x.NullNode) q.Enqueue(pre);
        for (int c = 0; c < 256; c++)
            Collect(x.Children[c], pre + ((char)c), q);
    }
}