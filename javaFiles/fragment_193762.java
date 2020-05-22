for(int i = 0; i < size; i++) {

    if(startnode.equalsIgnoreCase(nodes[i].getStartNode())) {

    neighbournodes.add(nodes[i].getEndNode());

        for(int j = 0; j < cost.length; j++) {

            if(nodes[i].getEndNode().equalsIgnoreCase(cost[j].getNode())) {

            h_cost.add(cost[j].getCost()); 

            }
        }
    }
}

System.out.println("neighbouring nodes are "+neighbournodes);
System.out.println("H_cost is "+h_cost);