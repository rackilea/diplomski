public class JacksonConversion {
    public static class FinancialTransaction {
        public Date tranDate;
        public String tranDescription;
        public Double debit;
        public Double credit;

        @Override
        public String toString() {
            return "FinancialTransaction{" +
                    "tranDate=" + tranDate +
                    ", tranDescription='" + tranDescription + '\'' +
                    ", debit=" + debit +
                    ", credit=" + credit +
                    '}';
        }
    }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("tranDate", new Date().getTime());
        map1.put("tranDescription", "descr");
        map1.put("debit", 123.45);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("tranDate", new Date().getTime());
        map2.put("tranDescription", "descr2");
        map2.put("credit", 678.9);

        System.out.println(mapper.convertValue(
                Arrays.asList(map1, map2),
                new TypeReference<List<FinancialTransaction>>() {}));
    }
}