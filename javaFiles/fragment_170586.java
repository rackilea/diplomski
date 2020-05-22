final List<Class<? extends Number>> list
        = new ArrayList<Class<? extends Number>>();

    // Both Integer and BigDecimal extend Number
    list.add(Integer.class);
    list.add(BigDecimal.class);