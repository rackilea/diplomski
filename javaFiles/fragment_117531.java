// no hasItem check needed
 var other = doc.getItemValue("fldOtherVal"); // must not be multivalue
 if ("".equals(other) || "0".equals(other)) {
      System.out.println("no relations");
      customer.setOther("0");
      customer.setOtherVal("0"); // update "otherVal" also
 } else {
      System.out.println("relations");
      customer.setOther("1");
      customer.setOtherVal("1"); // do not copy value, just set to "1"
 }