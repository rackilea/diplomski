// #1 (does compile)
List raw = null;
List<?> wild = raw;

// #2 (doesn't compile)
List<List> raw = null;
List<List<?>> wild = raw;