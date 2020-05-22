613     public boolean get(int bitIndex) {
614         if (bitIndex < 0)
615             throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
616 
617         checkInvariants();
618 
619         int wordIndex = wordIndex(bitIndex);
620         return (wordIndex < wordsInUse)
621             && ((words[wordIndex] & (1L << bitIndex)) != 0);
622     }