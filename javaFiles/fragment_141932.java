import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class TestRevertBitSet {

    public static class RevertableBitSet {

        private BitSet bitSet;
        private boolean flipped;

        private RevertableBitSet(BitSet bitSet) {
            this.bitSet = bitSet;
        }

        public static RevertableBitSet makeNew(char[] bitArray) {
            BitSet byteValue = new BitSet(bitArray.length);
            for (int i = 0; i < bitArray.length; i++) {
                if (bitArray[i] == '1') {
                    byteValue.flip(i);
                }
            }
            RevertableBitSet r = new RevertableBitSet(byteValue);
            if (r.hasZeroCardinality()) {
                r.flipAllBitsTrue();

            } else {
                r.revertBitsOrder();
            }
            return r;
        }

        public boolean hasAllBitsFlip() {
            return this.flipped;
        }

        /**
         * @return if all the bits are set.
         */
        public boolean hasZeroCardinality() {
            return this.bitSet.cardinality() == 0;
        }

        /**
         * Flips all bits from the given bitSet to true.
         */
        public void flipAllBitsTrue() {
            this.bitSet.set(0, this.bitSet.size());
            this.flipped = true;
        }

        /**
         * Reverts the bits sequence. For instance, from 01100 to 00110.
         */
        public void revertBitsOrder() {
            for (int i = 0; i < 4; i++) {
                boolean nthBit = this.bitSet.get(i);
                this.bitSet.set(i, this.bitSet.get(7 - i));
                this.bitSet.set(7 - i, nthBit);
            }
        }

        /**
         * @return a char array with values based on the bit indexes of the
         *         given bit set.
         */
        public char[] toCharArray() {
            char[] bitChars = new char[8];
            for (int i = 0; i < bitChars.length; i++) {
                bitChars[i] = bitSet.get(i) ? '1' : '0';
            }
            return bitChars;
        }

        /**
         * @param bitIndex
         * @return the boolean value of the given bit index.
         */
        public boolean getBitBooleanAtIndex(int bitIndex) {
            if (bitIndex > 7) {
                return false;
            }
            return this.bitSet.get(bitIndex);
        }

        /**
         * @param byteSetsList
         *            is the list of BitSet.
         * @return the integer representation of the entire bit set.
         */
        public static int convertSetToInteger(
                List<RevertableBitSet> byteSetsList) {
            int sum = 0;
            int index = 0;
            for (RevertableBitSet bitSet : byteSetsList) {
                if (bitSet.hasAllBitsFlip()) {
                    for (int i = 0; i < 8; i++) {
                        index++;
                    }
                    continue;
                }
                for (int i = 7; i >= 0; i--) {
                    int bit = bitSet.getBitBooleanAtIndex(i) ? 1 : 0;
                    int intValue = (int) Math.pow((double) 2, (double) index++)
                            * bit;
                    sum = sum + intValue;
                }
            }
            return sum;
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder();
            b.append("[ ");
            for (int i = 0; i < 7; i++) {
                b.append(i);
                b.append(" , ");
            }
            b.delete(0, b.length() - 2);
            b.append(" ]");
            return b.toString();
        }
    }

    public static void main(String[] args) throws IOException {

        int decimalNumber = 256;
        System.out.println("Decimal Number: " + decimalNumber);
        System.out.println(Integer.toBinaryString(decimalNumber));
        int numberBits = (int) Math.ceil(Math.log(decimalNumber) / Math.log(2)) + 1;
        int numberBytes = (int) (Math.ceil(Math.log(decimalNumber)
                / Math.log(2)) / 8) + 1;
        System.out.println("Number of bits: " + numberBits);
        System.out.println("Number of bytes: " + numberBytes);

        List<RevertableBitSet> bytesSet = new ArrayList<RevertableBitSet>();

        int bitsCounter = -1;
        char[] binaryChars = Integer.toBinaryString(decimalNumber)
                .toCharArray();
        char[] currentChars = new char[8];
        Arrays.fill(currentChars, '0');
        for (int i = binaryChars.length - 1; i >= 0; i--) {
            if (bitsCounter + 1 <= 7) {
                currentChars[++bitsCounter] = binaryChars[i];

            } else {
                RevertableBitSet bitSet = RevertableBitSet
                        .makeNew(currentChars);
                bytesSet.add(bitSet);

                bitsCounter = -1;
                Arrays.fill(currentChars, '0');
                currentChars[++bitsCounter] = binaryChars[i];
            }
        }

        bytesSet.add(RevertableBitSet.makeNew(currentChars));

        System.out.println("------------");

        for (RevertableBitSet bitSet : bytesSet) {
            System.out.println(Arrays.toString(bitSet.toCharArray()));
        }

        System.out.println("------------");
        System.out.println("Number: "
                + RevertableBitSet.convertSetToInteger(bytesSet));
    }
}