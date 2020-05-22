// Find a power of 2 >= initialCapacity
       int capacity = 1;
       while (capacity < initialCapacity)
           capacity <<= 1;

       this.loadFactor = loadFactor;
       threshold = (int)(capacity * loadFactor);
       table = new Entry[capacity];