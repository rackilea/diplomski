ISourceRange range = member.getSourceRange();
if (range == null){
  return null;
}

IBuffer buf = null;

ISourceModule compilationUnit = member.getSourceModule();
if (!compilationUnit.isConsistent()) {
  return null;
}

buf = compilationUnit.getBuffer();
final int start = range.getOffset();
String contents = buf.getContents();
Document doc = new Document(contents);
try {
  int line = doc.getLineOfOffset(start);
  ...