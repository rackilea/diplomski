public enum WorkStateEnums {
        WORK_EMPTY_CAR(000, "WORK_1", (R.string.thatvalue)),
        WORK_START(100, "WORK_START", (R.string.thatvalue)),
        WORK_END(200, "WORK_END", (R.string.thatvalue));

        private int arg1;
        private String arg2;
        @StringRes
        private int arg3;

        WorkStateEnums(int arg1, String arg2, int arg3) {
            this.arg1 = arg1;
            this.arg2 = arg2;
            this.arg3 = arg3;
        }

        public int getArg1() {
            return arg1;
        }

        public String getArg2() {
            return arg2;
        }

        public int getArg3() {
            return arg3;
        }

        // To get Arg3 value as available in strings.xml
        public String getArg3String(Context context) {
            return context.getResources().getString(arg3);
        }
    }