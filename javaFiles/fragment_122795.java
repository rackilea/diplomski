public boolean equals(Object anObject) {
       if (this == anObject) {
            return true;
       }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
           int n = count; //count is the length of return in the docs
            if (n == anotherString.count) {
                char v1[] = value;//The value is used for character storage.
               char v2[] = anotherString.value;
                int i = offset; //The offset is the first index of the storage that is used.
                int j = anotherString.offset;
                while (n-- != 0) {
                    if (v1[i++] != v2[j++])
                       return false;
               }
                return true;
            }
        }
        return false;
    }