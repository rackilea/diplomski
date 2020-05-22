List<Order> orders = ... your list ...
 Map<Date, List<Order>> orderMap = orders.stream().collect(Collectors.groupingBy(order->{
      //Converting from Date to Instant
      Instant dateInstant = order.getOrderDate().toInstant();
      //Converting Instant to LocalDateTime and setting it to the start of the day
      LocalDateTime dateTime = dateInstant.atZone(ZoneId.systemDefault()).toLocalDate().atStartOfDay();
      //Converting it back to an instant
      Instant startOfDayInstant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
      //Returning the util date
      return Date.from(startOfDayInstant);
    }));