String s = "{\"Tue Jan 13 00:00:00 MEZ 2015\":2131165194,\"Mon Jan 12 00:00:00 MEZ 2015\":2131165194,\n" +
            "\"Thu Dec 11 00:00:00 MEZ 2014\":2131165194,\"Fri Dec 12 00:00:00 MEZ 2014\":2131165194,\n" +
            "\"Mon Jan 19 00:00:00 MEZ 2015\":2131165194,\"Wed Dec 10 00:00:00 MEZ 2014\":2131165194,\n" +
            "\"Mon Jan 05 00:00:00 MEZ 2015\":2131165194}";
    Map<Date, Long> map = new GsonBuilder().setDateFormat("E MMM dd HH:mm:ss 'MEZ' yyyy").create().fromJson(s, new TypeToken<HashMap<Date, Long>>() {
    }.getType());