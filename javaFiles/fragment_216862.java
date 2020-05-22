class RegexpPatternProtos {
  public static RegexPatternProto encode(java.util.regex.Pattern pattern) {
    return RegexPatternProto.newBuilder()
        .setPattern(pattern.pattern())
        .setFlags(pattern.flags())
        .build();
  }

  public static java.util.regex.Pattern decode(RegexPatternProto patternProto) {
    return new RegexPatternProto(
      patternProto.getPattern(), patternProto.getFlags());
  }
}