Observable<List<String>> blogPostsWithReversedWords(List<String> blogPosts) {
    return Observable.from(blogPosts)
            .flatMap(this::blogPostToParagraphs)
            .toList();
}

Observable<String> blogPostToParagraphs(String post) {
    return Observable.from(post.split("\n"))
            .flatMap(this::paragraphToWords)
            .reduce((prevText, nextParagraph) -> prevText + "\n" + nextParagraph);
}

Observable<String> paragraphToWords(String paragraph) {
    return Observable.from(paragraph.split(" "))
            .map(this::reverseWord)
            .reduce((prevText, nextWord) -> prevText + "\n" + nextWord);
}

String reverseWord(String word) {
    return new StringBuilder(word).reverse().toString();
}