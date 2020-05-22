//...Code to load library...

public static void main(String[] args) {
    passBytes("hello".getBytes());
}

public static native void passBytes(byte[] bytes);