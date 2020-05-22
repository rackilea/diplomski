static final class Segment<K,V> extends ReentrantLock
   ...
   Segment(float lf, int threshold, HashEntry<K,V>[] tab) {
            this.loadFactor = lf;
            this.threshold = threshold;
            this.table = tab;
   }
   ...