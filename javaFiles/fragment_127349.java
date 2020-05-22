interface Strategy {

    int execute(int a, int b);
}

enum Math implements Strategy {

    Add {

                @Override
                public int execute(int a, int b) {
                    return a + b;
                }
            },
    Subtract {

                @Override
                public int execute(int a, int b) {
                    return a - b;
                }
            },
    Multiply {

                @Override
                public int execute(int a, int b) {
                    return a * b;
                }
            };
}