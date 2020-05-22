public class ACBinaryWrapper implements AutoCloseable {
    private Binary binary;

    public ACBinaryWrapper(Binary binary) {
        this.binary = binary;
    }

    public Binary getBinary() {
        return this.binary;
    }

    public void close() { 
        if (this.binary != null) {
            Binary b = this.binary;
            this.binary = null;
            b.dispose();
        }
    }
}