String s = "Market participants are requested to note that stock with code 83199 has multiple counters (stock codes: USD counter: 3199, EUR counter: 83199 and SWF counter: 9199) trading in their corresponding currency.";
Pattern pattern = Pattern.compile("(?:\\G(?!^)|\\(stock)[^()\\d]*(\\d+)(?=[^()]*\\))");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
} 
// => 3199, 83199, 9199