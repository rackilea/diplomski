BigInteger val = new BigInteger("1254789363254125");
public boolean odd(BigInteger val) {
    if(!val.mod(new BigInteger("2")).equals(BigInteger.ZERO))
        return true;
    return false;
}