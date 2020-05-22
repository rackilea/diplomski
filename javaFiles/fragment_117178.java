String str = "Lorem ipsum XYZ1234-123456-12 lorem ipsum";

Pattern pattern = Pattern.compile("[a-zA-Z]{3}(\\d\\D*){11}\\d");
Matcher matcher = pattern.matcher(str);

if (matcher.find()) {
    System.out.println(matcher.group());
}