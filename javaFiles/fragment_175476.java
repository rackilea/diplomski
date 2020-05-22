List<Size> resultList = new ArrayList<>();
List<String> maskAlreadyInList = new ArrayList<>();
int width;
String widthAsString, mask;
StringBuilder maskBuilder;
for(Size s : sizes) {
    width = s.getWidth();
    widthAsString = String.valueOf(width);
    maskBuilder = new StringBuilder(""+widthAsString.charAt(0));
    for(int i = 1; i < widthAsString.length(); i++) {
        maskBuilder.append("x");
    }
    mask = maskBuilder.toString();

    if (!maskAlreadyInList.contains(mask)) {
        resultList.add(s);
        maskAlreadyInList.add(mask);
    }
}

resultList.forEach(System.out::println);