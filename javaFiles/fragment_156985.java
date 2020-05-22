Random random = new Random();
StringBuilder builder = new StringBuilder();
builder.append(name.charAt(1))
       .append(surname.charAt(2))
       .append(Date_Of_Birth.getYear())
       .append(100 + random.nextInt(900)));
return builder.toString();