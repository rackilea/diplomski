public void  ensureCapacity(int minCapacity) {
191         int minExpand = (elementData != EMPTY_ELEMENTDATA)
192             // any size if real element table
193             ? 0
194             // larger than default for empty table. It's already supposed to be
195             // at default size.
196             : DEFAULT_CAPACITY;
197 
198         if (minCapacity > minExpand) {
199             ensureExplicitCapacity(minCapacity);
200         }
201     }
202 
203     private void  ensureCapacityInternal(int minCapacity) {
204         if (elementData == EMPTY_ELEMENTDATA) {
205             minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
206         }
207 
208         ensureExplicitCapacity(minCapacity);
209     }
210 
211     private void  ensureExplicitCapacity(int minCapacity) {
212         modCount++;
213 
214         // overflow-conscious code
215         if (minCapacity - elementData.length > 0)
216             grow(minCapacity);
217     }

    private void grow(int minCapacity) {
    234         // overflow-conscious code
    235         int oldCapacity = elementData.length;
    236         int newCapacity = oldCapacity + (oldCapacity >> 1);
    237         if (newCapacity - minCapacity < 0)
    238             newCapacity = minCapacity;
    239         if (newCapacity - MAX_ARRAY_SIZE > 0)
    240             newCapacity = hugeCapacity(minCapacity);
    241         // minCapacity is usually close to size, so this is a win:
    242         elementData = Arrays.copyOf(elementData, newCapacity);
    243     }
    244 
    245     private static int More ...hugeCapacity(int minCapacity) {
    246         if (minCapacity < 0) // overflow
    247             throw new OutOfMemoryError();
    248         return (minCapacity > MAX_ARRAY_SIZE) ?
    249             Integer.MAX_VALUE :
    250             MAX_ARRAY_SIZE;
    251     }