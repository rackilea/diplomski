final JavaRDD<Something> stage2 = stage1.sortBy( new Function<Something, Long>() {
  private static final long serialVersionUID = 1L;

  @Override
  public Long call( Something value ) throws Exception {
    return value.getTime();
  }
}, true, 1 );