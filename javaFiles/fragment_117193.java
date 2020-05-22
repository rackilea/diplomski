Collection<String> col = Collections2.transform(inputCol, new Function<Course, String>() {
  @Nullable
  @Override
  public String apply(@Nullable Course input) {
    //Here, specify how to extract the value you want from the Course.
    return input.getName();
  }
});