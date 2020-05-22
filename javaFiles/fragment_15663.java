package org.norsam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author samuele m.
 *
 */
public class Mu
{

    // nodes with that value
    private Map<Integer, Set<TItem>> previous = new HashMap<>();

    private TItem root = null;

    public void addItem(Integer child, Integer parent)
    {
        // find a parent
        TItem tparent = findAParentLike(parent);
        // create child and add it to the parent
        TItem titem = new TItem(child);
        tparent.addChildren(titem);
        // add children to the map of "existent" elements
        if (!previous.containsKey(child)) {
            previous.put(child, new HashSet<TItem>());
        }
        previous.get(child).add(titem);
    }

    /**
     * Which node has this value?
     *
     * @param parent
     */
    private TItem findAParentLike(Integer parent)
    {
        if (root == null) {
            root = new TItem(parent);
            previous.put(parent, new HashSet<TItem>());
            previous.get(parent).add(root);
            return root;
        }
        if (!previous.containsKey(parent)) {
            throw new RuntimeException("Node " + parent + " not found");
        }
        Set<TItem> elems = previous.get(parent);
        return elems.iterator().next(); // one "random"
    }

    public void visit()
    {
        visit(root, ""+root.value);
    }

    private void visit(TItem elem, String base)
    {
        for (Integer child : elem.children.keySet()) {
            System.out.println(base + ":" + child.intValue());
            for (TItem item : elem.children.get(child)) {
                visit(item, base + ":" + child.intValue());
            }
        }
    }

    public static void main(String[] args)
    {
        Mu mu = new Mu();
        mu.addItem(2, 1);
        mu.addItem(3, 2);
        mu.addItem(4, 3);
        mu.addItem(4, 2);
        mu.addItem(5, 4);
        mu.addItem(6, 4);
        mu.addItem(5, 4);
        mu.addItem(6, 2);
        mu.addItem(7, 6);
        mu.addItem(9, 1);

        mu.visit();
    }
}

class TItem
{
    public int value;
    public Map<Integer, Set<TItem>> children = new HashMap<>(0);

    TItem()
    {
    }

    TItem(int value)
    {
        this.value = value;
    }

    void addChildren(TItem titem)
    {
        if (!children.containsKey(titem.value)) {
            children.put(titem.value, new HashSet<TItem>());
        }
        children.get(titem.value).add(titem);
    }
}