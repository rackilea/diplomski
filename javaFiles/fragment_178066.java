854       public boolean equals(Object object) {
855           if (object == this) {
856               return true;
857           }
858           if (object instanceof String) {
859               String s = (String) object;
860               int hash = hashCode;  // Single read on hashCodes as they may change
861               int shash = s.hashCode;
862               if (count != s.count || (hash != shash && hash != 0 && shash != 0)) {
863                   return false;
864               }
865               for (int i = 0; i < count; ++i) {
866                   if (value[offset + i] != s.value[s.offset + i]) {
867                       return false;
868                   }
869               }
870               return true;
871           }
872           return false;
873       }