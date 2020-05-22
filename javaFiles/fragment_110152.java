public static void main(String... main) {
        DbMetaPojo obj = new DbMetaPojo();

        obj.setRecordID(10);
        obj.setRecordName("RECORDS");

        Record record = new Record();

        record.setLanguageId(20);
        record.setTitleEndDate("2013-12-22T00:00:00.000+0000");
        record.setTitleFeild(1);
        record.setTitleId(500);
        record.setTitleIDMap("SOME NULL");
        record.setTitleStartDate("2013-12-22T00:00:00.000+0000");

        List<Record> list = new ArrayList<Record>();
        list.add(record);
        obj.setRecords(list);

        Gson gson = new Gson();

        String json = gson.toJson(obj);

        System.out.println(json);
    }