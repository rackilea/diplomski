String swapLetters(String str, int firstIndex, int secondIndex) {
    if (firstIndex < 0 || firstIndex >= str.length()) {
        throw new IndexOutOfBoundsException("firstIndex '" + firstIndex + "' is out of bounds.");
    } else if (secondIndex < 0 || secondIndex >= str.length()) {
        throw new IndexOutOfBoundsException("secondIndex '" + secondIndex + "' is out of bounds.");
    } else if (firstIndex >= secondIndex) {
        throw new IndexOutOfBoundsException("firstIndex isn't before secondIndex");
    }


    StringBuilder newString = new StringBuilder(str.substring(0, firstIndex));
    newString.append(str.charAt(secondIndex)).append(str.substring(firstIndex + 1, secondIndex))
             .append(str.charAt(firstIndex)).append(str.substring(secondIndex + 1));

    return newString.toString();
}