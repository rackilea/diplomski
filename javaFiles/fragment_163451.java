public static byte[] serializeSearchMaterializationToByteArray(SearchMaterializationDto searchMaterializationDto) {
        return avroSerialize(SearchMaterializationDto.class, searchMaterializationDto);
    }

public static <T> byte[] avroSerialize(Class<T> clazz, Object object) {
    byte[] ret = null;
    try {
        if (object == null || !(object instanceof SpecificRecord)) {
            return null;
        }

        T record = (T) object;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Encoder e = EncoderFactory.get().directBinaryEncoder(out, null);
        SpecificDatumWriter<T> w = new SpecificDatumWriter<T>(clazz);
        w.write(record, e);
        e.flush();
        ret = out.toByteArray();
    } catch (IOException e) {

    }

    return ret;
}

public static SearchMaterializationDto deserializeToSearchMaterialization(byte[] avroBytes) {
    return avroDeserialize(avroBytes, SearchMaterializationDto.class, SearchMaterializationDto.getClassSchema());
}

public static <T> T avroDeserialize(byte[] avroBytes, Class<T> clazz, Schema schema) {
    T ret = null;
    try {
        ByteArrayInputStream in = new ByteArrayInputStream(avroBytes);
        Decoder d = DecoderFactory.get().directBinaryDecoder(in, null);
        SpecificDatumReader<T> reader = new SpecificDatumReader<T>(clazz);
        ret = reader.read(null, d);
    } catch (IOException e) {

    }

    return ret;
}