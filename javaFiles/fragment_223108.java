else if (sortField.equalsIgnoreCase("accountValue")) {    
  accountComparator = 
      Comparator.comparing((Account a) -> a.getAccountValue() == null)
                .thenComparingDouble((Account a) -> 
                                     Double.parseDouble(a.getAccountValue()));
}