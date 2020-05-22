String xml = "RANDOM STUFF<!-- <editable name=\"nameValue\"> --> - content goes here - <!-- </editable> -->RANDOM STUFF";
Pattern p = Pattern.compile("<!-- <editable name=(\".*\")?> -->(.*)<!-- </editable> -->");
Matcher m = p.matcher(xml);
if (m.find()) {
    System.out.println(m.group(2));
} else {
    System.out.println("no match found");
}