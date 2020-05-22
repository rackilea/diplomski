public class RateGroupingTest {

    private RateGrouping subject = new RateGrouping();

    @Test
    public void groups() {
        //given
        List<DataEntry> entries = List.of(
                new DataEntry(ADULT, X, new BigDecimal("3")),
                new DataEntry(ADULT, Y, new BigDecimal("5")),
                new DataEntry(ADULT, Z, new BigDecimal("7")),
                new DataEntry(CHILD, X, new BigDecimal("11")),
                new DataEntry(CHILD, Y, new BigDecimal("13")),
                new DataEntry(CHILD, Z, new BigDecimal("17")),

                new DataEntry(ADULT, X, new BigDecimal("13")),
                new DataEntry(ADULT, Y, new BigDecimal("25")),
                new DataEntry(ADULT, Z, new BigDecimal("37")),
                new DataEntry(CHILD, X, new BigDecimal("411")),
                new DataEntry(CHILD, Y, new BigDecimal("513")),
                new DataEntry(CHILD, Z, new BigDecimal("617"))
        );

        //when
        Map<PassType, PassTypeRate> actual = subject.group(entries);

        //then
        assertThat(actual.get(PassType.X))
                .isEqualTo(
                        PassTypeRate.builder()
                                .childRate(new BigDecimal("422"))
                                .adultRate(new BigDecimal("16"))
                                .build()
                );
        assertThat(actual.get(PassType.Y))
                .isEqualTo(
                        PassTypeRate.builder()
                                .childRate(new BigDecimal("526"))
                                .adultRate(new BigDecimal("30"))
                                .build()
                );
        assertThat(actual.get(PassType.Z))
                .isEqualTo(
                        PassTypeRate.builder()
                                .childRate(new BigDecimal("634"))
                                .adultRate(new BigDecimal("44"))
                                .build()
                );
    }
}