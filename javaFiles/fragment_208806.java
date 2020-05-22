public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));

    // this map holds all orders
    // for each order, it will have a List of orderItems
    // orderItems is a List of String
    Map<String, List<List<String>>> map = new LinkedHashMap<>();
    String line;
    while((line = br.readLine()) != null){
        String orderId = line.substring(0, 6);

        // find order
        List<List<String>> order = map.get(orderId);
        // if we dont have it yet, lets create it
        if (order == null) {
            order = new ArrayList<>();
            map.put(orderId, order);
        }

        List<String> orderItems;
        // if our order is empty, no items at all, create the first group of items
        if (order.isEmpty()) {
            orderItems = new ArrayList<>();
            order.add(orderItems);
        } else {
            // otherwise we get the last group of items
            orderItems = order.get(order.size()-1);
        }

        // if this group, already have 2 items, we create a new one
        if (orderItems.size() == 2) {
            orderItems = new ArrayList<>();
            order.add(orderItems);
        }

        // finally we add the item, to the group (orderItems)
        orderItems.add(line);
    }   
    br.close();

    // now lets check if it worked

    for (String orderId: map.keySet()) {
        System.out.println("OrderId: "+orderId);
        List<List<String>> order = map.get(orderId);
        int groupId = 800;
        for (List<String> orderItems: order) {
            System.out.println("  Group: "+groupId);
            for (String item: orderItems)
                System.out.println("    "+item);
            groupId++;
        }
    }
}