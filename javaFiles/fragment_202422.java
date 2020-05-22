int index = q.incrementAndGet();
if (index >= Xdisc.length) {
    break;
} // I'm assuming you meant there to be a brace here...

Integer[] temp_X;
temp_X = new Integer[Xdisc[0].length];
for (int s = 0; s < Xdisc[0].length; s++) {
    temp_X[s] = Xdisc[index][s];
}