public abstract class HashUtil {
    //determines that we want hash, that has size of 32 integers ( or 32*32 bits )
    private static final int hash_size = 32;

    //some constants that can be changed in sake of avoiding collisions
    private static final BigInteger INITIAL_HASH = BigInteger.valueOf(7);
    private static final BigInteger HASH_MULTIPLIER = BigInteger.valueOf(31);
    private static final BigInteger HASH_DIVIDER = BigInteger.valueOf(2).pow(32*hash_size);

    public static BigInteger computeHash(String arg){
        BigInteger hash = new BigInteger(INITIAL_HASH.toByteArray());
        for (int i=0;i<arg.length()/hash_size+1;i++){
            int[] tmp = new int[hash_size];
            for(int j=0;j<Math.min(arg.length()-32*i,32);j++){
                tmp[i]=arg.codePointAt(i*hash_size+j);
            }
            hash = hash.multiply(HASH_MULTIPLIER).add(new BigInteger(convert(tmp)).abs()).mod(HASH_DIVIDER);
        }
        //to reduce result space to something meaningful
        return hash;
    }

    public static BigInteger computeHash(String arg1,String arg2){
        //here I don't forgot about reducing of result space
        return computeHash(arg1).add(computeHash(arg2)).mod(HASH_DIVIDER);
    }

    private static byte[] convert(int[] arg){
        ByteBuffer byteBuffer = ByteBuffer.allocate(arg.length*4);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(arg);
        return byteBuffer.array();
    }

    public static void main(String[] args){
        String firstString="dslkjfaklsjdkfajsldfjaldsjflaksjdfklajsdlfjaslfj",secondString="unejrng43hti9uhg9rhe3gh9rugh3u94htfeiuwho894rhgfu";
        System.out.println(computeHash(firstString,secondString).equals(computeHash(secondString,firstString)));
    }