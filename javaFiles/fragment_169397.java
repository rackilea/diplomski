@Before
public void setUp() {
    translator = mock(Translator.class);
    when(translator.getText(any(), any()))
        .thenAnswer(AdditionalAnswers.returnsSecondArg());
    when(translator.getText(any()))
        .thenAnswer(AdditionalAnswers.returnsFirstArg());
}