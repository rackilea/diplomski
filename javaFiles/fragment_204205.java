public int put(int key, int value) { 
          int hash = (key % table.length);
          int initialHash = -1;
          int indexOfDeletedEntry = -1;
          int numberOfComparisons = 1;

          while (hash != initialHash
                      && (table[hash] == DeletedEntry.getUniqueDeletedEntry()
                      || table[hash] != null
                      && table[hash].getKey() != key)) {
                numberOfComparisons++;
                if (initialHash == -1)
                      initialHash = hash;
                if (table[hash] == DeletedEntry.getUniqueDeletedEntry())
                      indexOfDeletedEntry = hash;
                hash = (hash + 1) % table.length;
          }
          if ((table[hash] == null || hash == initialHash)
                      && indexOfDeletedEntry != -1) {
                table[indexOfDeletedEntry] = new HashEntry(key, value);
                size++;
          } else if (initialHash != hash)
                if (table[hash] != DeletedEntry.getUniqueDeletedEntry()
                           && table[hash] != null && table[hash].getKey() == key)
                      table[hash].setValue(value);
                else {
                      table[hash] = new HashEntry(key, value);
                      size++;
                }
          if (size >= maxSize)
                resize();
          return numberOfComparisons;
 }