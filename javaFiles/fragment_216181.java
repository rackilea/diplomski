if (getParent() == null) {
    setResult(RESULT_OK, intent);
} else {
    getParent().setResult(RESULT_OK, intent);
}
finish();