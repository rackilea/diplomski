customerList.stream()
.peek(c -> { 
   if (c.name == null) {
      // do something...
   }
}).filter(customerPredicate).collect(Collectors.toList());