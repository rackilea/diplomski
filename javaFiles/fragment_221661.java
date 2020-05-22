String[] parts = str.split("-");
for (String part: parts)
   if (this part has only numbers)
      return Integer.parseInt(part);
// if there are no only number parts
throw new RuntimeException("Not valid number part found!");