enum HeaderType {
  HEADER1,
  HEADER2,
  ...
}

private Map<HeaderType, String> headerAttribs = ...;

void setAttrib( HeaderType type, String value ) {
  headerAttribs.put(type, value);
}

String getAttrib( HeaderType type ) {
  return headerAttribs.get(type);
}

public String execute(HeaderType type ) {
    //Execute
}