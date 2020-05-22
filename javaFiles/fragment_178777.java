import java.util.ArrayList;
import java.util.Collection;

public class AutoComplete {

private class Node
{
    public int value;
    public Node firstChild;
    public Node nextSibling;

    public Node(int value)
    {
        this.value = value;
        firstChild = null;
        nextSibling = null;
    }
}

public final static char DELIMITER = '\u0001';

private Node root;
private int maxDepth;
private int size;

public AutoComplete()
{
    root = new Node('r');
    size = 0;
}

public AutoComplete (Collection<String> items)
{
    root = new Node('r');
    size = 0;
    for (String item : items)
    {
        if (!isEntry(item))
        {
            add(item);
        }
    }
}

public AutoComplete (String[] items)
{
    root = new Node('r');
    size = 0;
    for (String item : items)
    {
        if (!isEntry(item))
        {
            add(item);
        }
    }
}

public boolean add(String item)
{
    if (isEntry(item))
    {
        return false;
    }
    else if (add(root, item + DELIMITER, 0))
    {
        size++;
        int n = item.length();
        if (n > maxDepth)
        {
            maxDepth = n;
        }
        return true;
    }
    return false;
}

public String[] find(String prefix)
{
    String[] result = suggest(root, prefix, 0);
    if (result[0] == prefix)
    {
        return null;
    }
    else
    {
        return result;
    }
}

private boolean add(Node root, String word, int offset)
{
    if (offset == word.length())
    {
        return false;
    }
    int c = word.charAt(offset);
    Node last = null, next = root.firstChild;
    while (next != null)
    {
        if (next.value < c)
        {
            last = next;
            next = next.nextSibling;
        }
        else if (next.value == c)
        {
            return add(next, word, offset + 1);
        }
        else
        {
            break;
        }
    }

    Node node = new Node(c);
    if (last == null)
    {
        root.firstChild = node;
        node.nextSibling = next;
    }
    else
    {
        last.nextSibling = node;
        node.nextSibling = next;
    }

    for (int i = offset + 1; i < word.length(); i++)
    {
        node.firstChild = new Node(word.charAt(i));
        node = node.firstChild;
    }
    return true;
}

private boolean isEntry(String word)
{
    return isEntry(root, word + DELIMITER, 0);
}

private boolean isEntry(Node root, String word, int offset)
{
    if (offset == word.length())
    {
        return true;
    }
    int c = word.charAt(offset);
    Node next = root.firstChild;
    while (next != null)
    {
        if (next.value < c)
        {
            next = next.nextSibling;
        }
        else if (next.value == c)
        {
            return isEntry(next, word, offset + 1);
        }
        else
        {
            return false;
        }
    }
    return false;
}

private String[] suggest(Node root, String word, int offset)
{
    if (offset == word.length())
    {
        ArrayList<String> words = new ArrayList<String>(size);
        char[] chars = new char[maxDepth];
        for (int i = 0; i < offset; i++)
        {
            chars[i] = word.charAt(i);
        }
        getAll(root, words, chars, offset);
        return words.toArray(new String[words.size()]);
    }
    int c = word.charAt(offset);
    Node next = root.firstChild;
    while (next != null)
    {
        if (next.value < c)
        {
            next = next.nextSibling;
        }
        else if (next.value == c)
        {
            return suggest(next, word, offset + 1);
        }
        else
        {
            break;
        }
    }
    return new String[] { word };
}

private void getAll(Node root, ArrayList<String> words, char[] chars, int pointer)
{
    Node n = root.firstChild;
    while (n != null)
    {
        if (n.firstChild == null)
        {
            words.add(new String(chars, 0, pointer));
        }
        else
        {
            chars[pointer] = (char)n.value;
            getAll(n, words, chars, pointer + 1);
        }
        n = n.nextSibling;
    }
}
}