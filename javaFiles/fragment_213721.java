//      use long.class rather than Long.class ---v
when(jdbcTemplate.queryForObject(anyString(), eq(long.class))).thenReturn(1L);


 //                      v--- matched: return 1L
assertThat(jdbcTemplate.queryForObject("<any>", long.class), is(1L));

try {
    //                        v--- mismatched: return null
    long value = jdbcTemplate.queryForObject("<any>", Long.class);
    //   ^--- throws NullPointerException when doing unboxing operation  
    fail();
} catch (NullPointerException expected) {
    assertTrue(true);
}