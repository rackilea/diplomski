public class Program {

    public static class TermsAndConditions {
        public Paragraph[] paragraphs;
    }

    public static class Paragraph {
        public String title;
        public Clause[] clauses;
    }

    public static class Clause {
        public String title;
        public String text;
    }

    private static final String json = "{\r\n"
            + "    \"paragraphs\": [\r\n"
            + "        {\r\n"
            + "            \"title\": \"Allgemeines \\u00a7 01\",\r\n"
            + "            \"clauses\": [\r\n"
            + "                {\r\n"
            + "                    \"title\": \"01. Absatz\",\r\n"
            + "                    \"text\": \"Nachstehende Allgemeine Gesch\\u00e4ftsbedingungen (AGB) gelten f\\u00fcr alle, auch zuk\\u00fcnftigen, Vertr\\u00e4ge, Lieferungen und sonstigen Leistungen der Firma Queen of Catwalk GmbH, In den Kuhwiesen 10, 76149 Karlsruhe (Nachstehend: Queen of Catwalk), gegen\\u00fcber ihren gewerblichen Kunden. Es gilt stets die zum Zeitpunkt der Bestellung g\\u00fcltige Fassung der AGB.\"\r\n"
            + "                },\r\n"
            + "                {\r\n"
            + "                    \"title\": \"02. Absatz\",\r\n"
            + "                    \"text\": \"Abweichende Vorschriften der Kunden werden hiermit widersprochen; andere Bedingungen werden nicht Vertragsinhalt, auch dann nicht, wenn wir ihnen nicht ausdr\\u00fccklich widersprechen.\"\r\n"
            + "                },\r\n"
            + "                {\r\n"
            + "                    \"title\": \"03. Absatz\",\r\n"
            + "                    \"text\": \"Die Gesch\\u00e4ftsbedingungen zwischen Queen of Catwalk und dem Kunden unterliegen dem Recht der Bundesrepublik Deutschland unter Ausschluss des UN Kaufrechts. Als Gerichtsstand ist Karlsruhe vereinbart, soweit es sich beim K\\u00e4ufer um einen Kaufmann im Sinne des HGB handelt. Ist der K\\u00e4ufer kein Kaufmann im Sinne des HGB, bleibt es bei der gesetzlichen Regelung \\u00fcber den Gerichtsstand.\"\r\n"
            + "                }\r\n" + "            ]\r\n" + "        }\r\n" + "    ]\r\n" + "}";

    public static void main(String[] args) {
        TermsAndConditions t = fromJson(json, TermsAndConditions.class);
        System.out.println(t);
    }

    private static <T> T fromJson(final String json, final Class<T> classOfT) throws JsonParseException {
        Gson gson = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL).create();
        T object = gson.fromJson(json, classOfT);
        return object;
    }
}