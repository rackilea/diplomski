StringBuilder strBuilder = "SELECT p FROM projects";
entityManager.createQuery(strBuilder.toString());  
Iterator<Order> orderIterator = sort.iterator();
Order order = orderIterator.next();
strBuilder.append(" Order By ").append(order.getProperty()).append(" ")
                .append(order.getDirection().name());