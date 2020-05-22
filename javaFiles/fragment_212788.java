int wordIndex = words.length - 1;

while (matcher.find()) {
    if (words.length > wordIndex) {
        matcher.appendReplacement(sb, words[wordIndex]);
        wordIndex++;
    }
}