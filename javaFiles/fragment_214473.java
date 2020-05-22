public class BasicHash extends Structure {
    public interface Reset extends Callback {
        public void invoke();
    }
    public Reset reset;
    public BasicHash() { }
    public BasicHash(Pointer p) { super(p); read(); }
}

BasicHash hash = mylib.getAlgorithmInstance(0);
hash.reset.invoke();