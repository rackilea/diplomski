List<String> fields = new ArrayList<>();
fields.add("1:true");
fields.add("2:true");
fields.add("3:false");
fields.add("4:false");
fields.add("5:false");
combine(fields).forEach(c -> System.out.println(c));