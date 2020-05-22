List<String> moneyValues = new ArrayList<String>() {{
    add("$42.35"); add("Fee: $10.25"); add("฿1200");
    add("obviously not valid input"); 
    add("not too 42 sure . 12about this one"); 
    add("or this $..3"); 
    add("$42.35 $84.50");
}};

for (String value : moneyValues) {
    try {   
        BigDecimal parsed = Program.forceBigDecimal(value); 
        System.out.println(parsed);
    } catch (NumberFormatException ex) { 
        ex.printStackTrace();
        continue;
    }
}