private static int getQuestionID(final Resources res, final int index) {
    final String[] questions = res.getStringArray(R.array.questions);
    return res.getIdentifier(questions[index],
                 "array",
                 "com.packtpub.kitchendroid");
}