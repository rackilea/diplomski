final Map<Integer, FileDesc> history = new HashMap<>();
final Set<File> files = new HashSet<>();
history.put(-1, new FileDesc(basePath, false));
for (String line : inputLines) {
  final int indent = indentSize(line);
  final String fileName = fileName(line);
  final FileDesc 
    parent = history.get(indent-1),
    previous = history.get(indent),
    current = new FileDesc(new File(parent.f, fileName), true);
  parent.isFile = false;
  if (previous != null && previous.isFile) files.add(previous.f);
  history.put(indent, current);
}
for (FileDesc desc : history.values())
  if (desc.isFile) files.add(desc.f);