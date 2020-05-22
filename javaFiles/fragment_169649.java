class BinaryMap {
    public int countValues(boolean value) {
        ...
    }
}

class BinaryMapTest {
    @Test
    void testInitialisation() {
        BinaryMap map = new BinaryMap():
        assertThat(map.countValues(false)).isEqualTo(100);
        assertThat(map.countValues(true)).isEqualTo(0);
    }
}