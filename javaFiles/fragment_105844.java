ArrayDeque<BigInt> deque = new ArrayDeque<BigInt>();
//populate deque

BigInt sum = new BigInt("0");
for(BigInt b : deque) {
    sum = sum.add(b);
}

//sum now holds the sum of the elements in deque.