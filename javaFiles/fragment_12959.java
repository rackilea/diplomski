ArrayList<String> lines = new ArrayList<>();
int index = 0;
while(index < textArray.length()) {
    StringBuilder builder = new StringBuilder();
    if(textArray[index].length() >= 99) {
        build.append(textArray[index]);
        index++;
    } else {
        while(builder.length() < 99 - (textArray[index].length())) {
            builder.append(textArray[index] + " ");
            index++;
            if(!(index < textArray.length()) {
                break;
            }
    }
    lines.add(builder.toString());
}