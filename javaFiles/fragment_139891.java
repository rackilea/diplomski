@Component
            public class CustomDateDeserializer extends StdDeserializer<Date> {

                /**
                * 
                */
                private static final long serialVersionUID = 1L;
                private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // specify your specific timezone

                public CustomDateDeserializer() {
                this(null);
                }

                public CustomDateDeserializer(Class<?> vc) {
                super(vc);
                }

                @Override
                public Date deserialize(JsonParser jsonparser, DeserializationContext context)
                    throws IOException, JsonProcessingException {
                String date = jsonparser.getText();
                try {
                    return formatter.parse(date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                }
            }