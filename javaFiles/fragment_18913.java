164       public String(String original) {
  165           int size = original.count;
  166           char[] originalValue = original.value;
  167           char[] v;
  168           if (originalValue.length > size) {
  169               // The array representing the String is bigger than the new
  170               // String itself.  Perhaps this constructor is being called
  171               // in order to trim the baggage, so make a copy of the array.
  172               int off = original.offset;
  173               v = Arrays.copyOfRange(originalValue, off, off+size);
  174           } else {
  175               // The array representing the String is the same
  176               // size as the String, so no point in making a copy.
  177               v = originalValue;
  178           }
  179           this.offset = 0;
  180           this.count = size;
  181           this.value = v;