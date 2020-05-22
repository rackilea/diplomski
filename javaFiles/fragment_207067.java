ArrayList<Node> tempList = new ArrayList<Node>();
For(Node a:state.children)
{
    state.value = Math.max(state.value,min_value(a, alpha, beta));
    alpha = Math.max(alpha,state.value);
    if(beta <=alpha)
    {
        System.out.println("The elements that are going to be skipped are: " + a.label);
    } else {
        tempList.add(a);
    }

}