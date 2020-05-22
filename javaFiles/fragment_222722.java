Main.mainMethod(new Method() {
            public boolean call(int value1, int value2, int value3) {
                int A = value1;
                int B = value2;
                int C = value3;
                return A|B|C;//This does not compile
            }
        },1,2,3);