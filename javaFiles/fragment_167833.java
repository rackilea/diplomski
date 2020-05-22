static void putLongB(ByteBuffer bb, int bi, long x) {
bb._put(bi + 0, long7(x));
bb._put(bi + 1, long6(x));
bb._put(bi + 2, long5(x));
bb._put(bi + 3, long4(x));
bb._put(bi + 4, long3(x));
bb._put(bi + 5, long2(x));
bb._put(bi + 6, long1(x));
bb._put(bi + 7, long0(x));
}