String Text = "AAA1.0BBB2.2CCC33.3";
Pattern pattern = Pattern.compile("[A-Z]{3}[0-9]*\\.[0-9]*");
Matcher matcher = pattern.matcher(Text);
while (matcher.find()){
    System.out.println(matcher.group(0)); 
}