final ArrayList<ArrayList<Element>> child = new ArrayList<ArrayList<Element>>();

    final int level = ListTree.size() - 1;

    for (int i = 0; i < ListTree.get(level).size(); i++)
    {

        for (int j = 0; j < ListTree.get(level).get(i).size(); j++)
        {
            final ArrayList<Element> childOfChild = new ArrayList<Element>();
            childOfChild.addAll(getChildren(ListTree.get(level).get(i).get(j)));
            if (childOfChild.size() > 0)
            {
                child.add(childOfChild);
            }

        }
    }
    if (child.size() > 0)
    {
        ListTree.add(child);
        GetAllXml(ListTree);
    }