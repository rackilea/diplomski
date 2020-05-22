public class ExcelTransfer extends ByteArrayTransfer {

    private static final String TYPE_NAME = "XML Spreadsheet";
    private static final int TYPE_ID = registerType(TYPE_NAME);

    private static final ExcelTransfer _instance = new ExcelTransfer();

    private ExcelTransfer() {
    }

    /**
     * @return
     */
    public static ExcelTransfer getInstance() {
        return _instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int[] getTypeIds() {
        return new int[] { TYPE_ID };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String[] getTypeNames() {
        return new String[] { TYPE_NAME };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void javaToNative(final Object object, final TransferData transferData) {
        // ...
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object nativeToJava(final TransferData transferData) {
        if (!isSupportedType(transferData)) {
            return null;
        }

        final byte[] buffer = (byte[]) super.nativeToJava(transferData);
        if (buffer == null) {
            return null;
        }

        final File f = new File("excel_clipboard.xml");
        try {
            f.createNewFile();
            final FileOutputStream fo = new FileOutputStream(f);
            fo.write(buffer);
            fo.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}