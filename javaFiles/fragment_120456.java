private static IntPair heightUnbalance(BinTree t) {
    if(t == null) 
        return new IntPair(0, 0);
    else {
        IntPair leftResult = heightUnbalance(t.left);
        IntPair rightResult = heightUnbalance(t.right);
        return new IntPair(1+Math.max(leftResult.height,rightResult.height),
                           Math.abs(leftResult.height-rightResult.height));
    }
}