private Element heuristic_Function(List<Element> objectList) {
    System.out.println(objectList.toString());
    Element node =objectList.get(0); // REPLACE WITH THIS
    double leastValue = objectList.get(0).getGreedy();
    System.out.println(leastValue);

    for (Element e : objectList) {


        if (leastValue > e.getGreedy()) {


            leastValue = e.getGreedy();
            node = e;
        }

    }
    System.out.println(node.toString());
    System.out.println(leastValue);
    return node;
}