class BookAnalyserImpl implements BookAnalyser
    // Pass in analyser factory and book parser
    // to constructor so mocked version can
    // be used for testing
    public BookAnalyserImpl(TextAnalyserFactory textAnalyserFactory,
                            BookParser bookParser) {
        if(null != textAnalyserFactory) {
           mTextAnalyserFactory = textAnalyserFactory;
        } else {
           mTextAnalyserFactory = new AnalyserFactoryImpl();
        }
        // Same for bookParser
    }
    BookAnalysis analyse(String bookText) {
        BookAnalysis bookAnalysis = new BookAnalysis();
        ChapterAnalyser chapterAnalyser = mTextAnalyserFactory.GetChapterAnalyser();

        foreach(chapterText in mBookParser.splitIntoChapters(bookText)) {
            bookAnalysis.AddChapterAnalysis(chapterAnalyser.analyse(chapterText));
        }
    }
}

class TextAnalyserFactoryImpl implements TextAnalyserFactory {
    ChapterAnalyser GetChapterAnalyser() {...}
}

class ChapterAnalyserImpl implements ChapterAnalyser {
     ChapterAnalysis analyse(String chapterText) { ... }
}