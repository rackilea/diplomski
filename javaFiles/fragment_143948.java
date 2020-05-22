QuestionHandler handler = QuestionHandlerFactory.create();

try {
    handler.handle(question);
} catch( UnhandledQuestionException ex ) {
    System.out.println(ex.getMessage());
}