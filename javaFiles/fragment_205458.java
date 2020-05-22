@Field(name = "greekTitle" analyzer = @Analyzer(impl = GreekAnalyzer.class))
public void getGreekTitle(){
 //...
}

@Field(name = "englishTitle" analyzer = @Analyzer(impl = StandardAnalyzer.class))
public void getEnglishTitle(){
 //...
}