public static void main(String[] args) {
        List<Statictics> statictics = new ArrayList<>();
        statictics.add(new Statictics(4, new Date(), "TOTO", 1, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(8, new Date(), "TOTO", 1, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(12, new Date(), "TOTO", 1, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(32, new Date(), "TOTO", 2, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(56, new Date(), "TOTO", 2, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(57, new Date(), "TOTO", 2, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(78, new Date(), "TOTO", 2, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(84, new Date(), "TOTO", 3, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(87, new Date(), "TOTO", 3, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(151, new Date(), "TOTO", 4, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(155, new Date(), "TOTO", 4, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(159, new Date(), "TOTO", 4, "FR", "RFQ DISTRIBUTOR"));
        statictics.add(new Statictics(169, new Date(), "TOTO", 5, "FR", "RFQ DISTRIBUTOR"));

        statictics.stream()
                .collect(Collectors.groupingBy(Statictics::getCode))
                .entrySet().stream()
                .map(e -> e.getValue().get(0))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    private static class Statictics {
        int id;
        Date date;
        String company;
        int code;
        String page;
        String version;

        public Statictics(int id, Date date, String company, int code, String page, String version) {
            this.id = id;
            this.date = date;
            this.company = company;
            this.code = code;
            this.page = page;
            this.version = version;
        }

        @Override
        public String toString() {
            return "id : " + id + " code : " + code;
        }

        public int getCode() {
            return code;
        }
    }