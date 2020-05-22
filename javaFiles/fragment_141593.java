import java.util.zip.CRC32;

public class HugeStringCollection {
    private Collection<String> strings;

    public HugeStringCollection(Collection<String> strings) {
        this.strings = strings;
    }

    public int hashCode() {
        CRC32 crc = new CRC32();
        for(String string : strings) {
            crc.update(string.getBytes())
        }

        return (int)( crc.getValue() );
    }
}