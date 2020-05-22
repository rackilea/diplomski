195    public ArrayDeque(int numElements) {
196        allocateElements(numElements);
197    }

124    private void allocateElements(int numElements) {
125        int initialCapacity = MIN_INITIAL_CAPACITY;
126        // Find the best power of two to hold elements.
127        // Tests "<=" because arrays aren't kept full.
128        if (numElements >= initialCapacity) {
129            initialCapacity = numElements;
130            initialCapacity |= (initialCapacity >>>  1);
131            initialCapacity |= (initialCapacity >>>  2);
132            initialCapacity |= (initialCapacity >>>  4);
133            initialCapacity |= (initialCapacity >>>  8);
134            initialCapacity |= (initialCapacity >>> 16);
135            initialCapacity++;
136
137            if (initialCapacity < 0)   // Too many elements, must back off
138                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
139        }
140        elements = (E[]) new Object[initialCapacity];
141    }