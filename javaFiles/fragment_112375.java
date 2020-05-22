class FixedBitSet extends BitSet {

    private int maxLength = 0;

    public int maxLength(){
        return maxLength;
    }

    @Override
    public void set(int bitIndex, boolean value) {
        super.set(bitIndex, value);
        if(bitIndex > maxLength){
            maxLength = bitIndex;
        }
    }

}