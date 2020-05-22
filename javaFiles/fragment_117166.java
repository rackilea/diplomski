T t = null;
int count = 0;
for (Entry<T, Integer> e: hist.entrySet()) {
   if (e.getValue() > count) {
      count = e.getValue();
      t = e.getKey();
   }
}
return t;