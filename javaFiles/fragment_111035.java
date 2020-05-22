class Outer {
    int value; /* #1 */

    class Inner {
        int value; /* #2 */

        void setInnerValue(int value /* #3 */) {
            //    #2      #3
            //   vvvvv   vvvvv
            this.value = value;
        }

        void setOuterValue(int value /* #4 */) {
            //          #1      #4
            //         vvvvv   vvvvv
            Outer.this.value = value;
        }
    }
}