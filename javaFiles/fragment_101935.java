@RequestMapping(method = RequestMethod.POST, value="/api/saveholiday")
    public ResponseEntity<Map<String, Holiday>> saveHoliday(@RequestBody Holiday holiday) throws JsonProcessingException {
        System.out.println(holiday);

        fakeItTest();

        return null;
    }

    private void fakeItTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Set<GiftSet> giftSets2 = new HashSet<>();
        GiftSet gg = new GiftSet();
        gg.setId(1111);
        gg.setHoliday(new Holiday());
        giftSets2.add(gg);

        GiftSet gg2 = new GiftSet();
        gg2.setId(1112);
        gg2.setHoliday(new Holiday());
        giftSets2.add(gg2);

        Holiday holiday2 = new Holiday();
        holiday2.setName("HolidaySet");
        holiday2.setGiftSets(giftSets2);

        String a = objectMapper.writeValueAsString(holiday2);
        System.out.println(a);
    }


    @Data
    public  static class Holiday{
        private String name;
        private Set<GiftSet> giftSets;
    }

    @Data
    public static class  GiftSet {
        private Integer id;
        private Holiday holiday;
    }