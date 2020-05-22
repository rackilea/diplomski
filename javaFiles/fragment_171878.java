int index = text.indexOf(pattern);
while (index >= 0) {
    result.add(index);
    index = text.indexOf(pattern, index + 1);
}
return result;
}