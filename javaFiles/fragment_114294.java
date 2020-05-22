final Object obj = inputStream.readObject();
if(obj instanceof A) {
  final A a = (A)obj;
} else {
  final B a = (B)obj;
}