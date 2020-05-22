for (int i = 0, l = images.size(); i < l; i++) {
    stringBuffer.append(images.get(i).path)
    if (i < l-1) {
        stringBuffer.append(",");
    }
    stringBuffer.append("\n");
}