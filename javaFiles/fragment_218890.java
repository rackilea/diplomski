@Captor
ArgumentCaptor<Object[]> objCap;
@Captor
ArgumentCaptor<int[]> intCap;

when(mJdbcTemplate.update(anyString(), objCap.capture(), intCap.capture())).thenReturn(1);