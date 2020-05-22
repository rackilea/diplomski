public Dog findParent(Dog root, String name)
{
    String top = "Spot";
    if(top.equals(name))
    {
        System.out.println("No further records");
        System.out.println("Goodbye.");
        System.exit(0);
    }
    for(int i = 0; root.children != null && i < root.children.length; i++)
    {
        if(root.children[i].name.equals(name))
        {
            return root;
        }
        else
        {
            Dog parent = findParent(root.children[i], name);
            if (parent != null) 
                 return parent;
        }
    }
    return null;
}