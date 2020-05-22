Pointer[] ptrs = stdevs.getValue().getPointerArray(0, size.intValue());
DevStruct[] array = new DevStruct[size.intValue()];
for (int i=0;i < array.length;i++) {
    array[i] = new DevStruct(ptrs[i]);
}

public class DevStruct extends Structure {
    public DevStruct(Pointer p) {
        super(p);
        read();
    }
}