private static final String FORMAT = "<%d>:%s";

// ...

for(int i=0; i< list.size(); i++) {
   long item = list.get(i);
   set.add(String.format(FORMAT, i, String.valueOf(item)));
}