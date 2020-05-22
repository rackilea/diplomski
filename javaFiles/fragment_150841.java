public void dls(ArrayList<String> results, Node node, String goal)
{
    if (node.data.contains(goal))
    {
        results.add(node.data);
    }
    for(Node child : node.children)
    {
        dls(child, goal, depth-1);
    }
}