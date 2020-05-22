public static void main(String[] args) {
System.out.println("Hello, OpenCV");

// Load the native library.
//System.loadLibrary(Core.NATIVE_LIBRARY_NAME); instead by below code
String path = "/home/administrator/OpenCV_jar/libopencv_java310.so";
System.load(path);
new DetectFaceDemo().run();
}