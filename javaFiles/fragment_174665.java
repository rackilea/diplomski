void reduceArrayFast(long[] data, long denominator){
    FastDivision.Magic magic = FastDivision.magicSigned(denominator);
    for(int i = 0; i < data.length; ++i)
        // computes data[i] / denominator
        data[i] = FastDivision.divideSignedFast(data[i], magic);
}