// orders is what you deserialize from JSON
List<MyOrder> orders = new LinkedList<>();
Map<String, MyOrderMapped> mappedById = orders
            .stream()
            .map(o -> new MyOrderMapped(o.getOrderNum(), 
                                        o.getOrderType(), 
                                        o.getOrderContent()))
            .collect(Collectors.toMap(MyOrderMapped::getOrderNum, Function.identity()));