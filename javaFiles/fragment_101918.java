private String createSearchFieldContent(Report report) {
  return createSearchFieldContent(report.getTitle(), report.getDescription(), report.getOwner());
}

private String createSearchFieldContent(OverrideableStringValue title,
                                        OverrideableStringValue description, OverrideableStringValue owner) {

  StringBuilder builder = new StringBuilder(getValue(title));
  if (StringUtils.isNotBlank(getValue(description))) {
    builder.append(" ").append(getValue(description));
  }
  if (StringUtils.isNotBlank(getValue(owner))) {
    builder.append(" ").append(getValue(owner));
  }
  String searchTerm = StringUtils.replaceAll(builder.toString(), "\n", " ");
  return unaccent(searchTerm);
}