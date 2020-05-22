public class DateTimeSerializerTemplate extends AbstractTemplate<DateTime> {
    private DateTimeSerializerTemplate() {

    }

    public void write(Packer pk, DateTime target, boolean required) throws IOException {
        if (target == null) {
            if (required) {
                throw new MessageTypeException("Attempted to write null");
            }
            pk.writeNil();
            return;
        }
        pk.write(target.getMillis());
    }

    public DateTime read(Unpacker u, DateTime to, boolean required) throws IOException {
        if (!required && u.trySkipNil()) {
            return null;
        }
        return new DateTime(u.readLong(), DateTimeZone.UTC);
    }

    static public DateTimeSerializerTemplate getInstance() {
        return instance;
    }

    static final DateTimeSerializerTemplate instance = new DateTimeSerializerTemplate();

}