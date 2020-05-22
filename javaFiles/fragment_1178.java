List<BigDecimal> list = new ArrayList<>();
          list.add(new BigDecimal(0));
          list.add(new BigDecimal(-2));
          list.add(new BigDecimal(10));
          list.add(new BigDecimal(200));
          if ((Collections.max(list).subtract(Collections.min(list)).compareTo(new BigDecimal(0)) != 0)) {
                System.out.println("OK");
          }