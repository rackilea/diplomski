public class TsvMessageConverter extends AbstractHttpMessageConverter<TsvResponse> {

    public static final MediaType MEDIA_TYPE = new MediaType("text", "tsv", Charset.forName("utf-8"));
    private static final Logger logger = LoggerFactory.getLogger(TsvMessageConverter.class);

    public TsvMessageConverter() {
        super(MEDIA_TYPE);
    }

    protected boolean supports(Class<?> clazz) {
        return TsvResponse.class.equals(clazz);
    }

    @Override
    protected TsvResponse readInternal(Class<? extends TsvResponse> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    protected void writeInternal(TsvResponse tsvResponse, HttpOutputMessage output) throws IOException, HttpMessageNotWritableException {
        output.getHeaders().setContentType(MEDIA_TYPE);
        output.getHeaders().set("Content-Disposition", "attachment; filename=\"" + tsvResponse.getFilename() + "\"");
        final OutputStream out = output.getBody();

        writeColumnTitles(tsvResponse, out);

        if (tsvResponse.getRecords() != null && tsvResponse.getRecords().size() != 0) {
            writeRecords(tsvResponse, out);
        }

        out.close();
    }

    private void writeRecords(TsvResponse response, OutputStream out) throws IOException {
        List<String> getters = getObjectGetters(response);
        for (final Object record : response.getRecords()) {
            for (String getter : getters) {
                try {
                    Method method = ReflectionUtils.findMethod(record.getClass(), getter);
                    out.write(method.invoke(record).toString().getBytes(Charset.forName("utf-8")));
                    out.write('\t');
                } catch (IllegalAccessException | InvocationTargetException e) {
                    logger.error("Erro ao transformar em CSV", e);
                }
            }
            out.write('\n');
        }
    }

    private List<String> getObjectGetters(TsvResponse response) {
        List<String> getters = new ArrayList<>();
        for (Method method : ReflectionUtils.getAllDeclaredMethods(response.getRecords().get(0).getClass())) {
            String methodName = method.getName();
            if (methodName.startsWith("get") && !methodName.equals("getClass")) {
                getters.add(methodName);
            }
        }
        sort(getters);
        return getters;
    }

    private void writeColumnTitles(TsvResponse response, OutputStream out) throws IOException {
        for (String columnTitle : response.getColumnTitles()) {
            out.write(columnTitle.getBytes());
            out.write('\t');
        }
        out.write('\n');
    }
}