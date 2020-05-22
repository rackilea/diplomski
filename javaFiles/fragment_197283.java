public static void main(String[] args) {
    // some setup code for this test:
    JavaSparkContext sc = new JavaSparkContext("local", "test");

    // input:
    final JavaRDD<String[]> input = sc.parallelize(Lists.newArrayList(
            //              date        time     ?    object     region
            new String[]{"2016-03-28", "11:00", "X", "object1", "region1"},
            new String[]{"2016-03-28", "11:01", "Y", "object1", "region1"},
            new String[]{"2016-03-28", "11:05", "X", "object1", "region1"},
            new String[]{"2016-03-28", "11:09", "X", "object1", "region1"},
            new String[]{"2016-03-28", "11:00", "X", "object2", "region1"},
            new String[]{"2016-03-28", "11:01", "Z", "object2", "region1"}
    ));

    // grouping by key:
    final JavaPairRDD<String, Iterable<String[]>> byObjectAndDate = input.groupBy(new Function<String[], String>() {
        @Override
        public String call(String[] record) throws Exception {
            return record[0] + record[3] + record[4]; // date, object, region
        }
    });

    // mapping each "value" (all record matching key) to result
    final JavaRDD<String[]> result = byObjectAndDate.mapValues(new Function<Iterable<String[]>, String[]>() {
        @Override
        public String[] call(Iterable<String[]> records) throws Exception {
            final Iterator<String[]> iterator = records.iterator();
            String[] previousRecord = iterator.next();
            int diffMinutes = 0;

            for (String[] record : records) {
                if (record[2].equals("X")) {  // if I got your intention right...
                    final LocalDateTime prev = getLocalDateTime(previousRecord);
                    final LocalDateTime curr = getLocalDateTime(record);
                    diffMinutes += Period.fieldDifference(prev, curr).toStandardMinutes().getMinutes();
                }
                previousRecord = record;
            }

            return new String[]{
                    previousRecord[0],
                    Integer.toString(diffMinutes),
                    previousRecord[3],
                    previousRecord[4]
            };
        }
    }).values();

    // do whatever with "result"...
}

// extracts a Joda LocalDateTime from a "record"
static LocalDateTime getLocalDateTime(String[] record) {
    return LocalDateTime.parse(record[0] + " " + record[1], formatter);
}

static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");