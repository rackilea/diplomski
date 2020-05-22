class Result {
    private final int length;
    private final byte[] byteArr;

    Result(int length, byte[] byteArr) {
        this.length = length;
        this.byteArr = byteArr;
    }

    public int getLength() {
        return length;
    }

    public byte[] getByteArr() {
        return byteArr;
    }
}

public static Result  readVarInt(DataInputStream in) throws IOException {
    ...
    return new Result(i, byteArr);
}

....

Result result = readVarInt(serv_input);

int intLength = result.getLength();
byte[] byteArray = result.getByteArr();