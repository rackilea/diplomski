boolean f1(int a, int b) { }
boolean f2(int a, int b) { }
void A(int a, int b) { }

void testAndA(BiPredicate<Integer, Integer> p, int a, int b) {
    if (p.test(a, b))
        A(a, b);
}