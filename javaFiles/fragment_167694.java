@Test
public void shouldReturnLengthOfVector() {
    Vector3D v1= new Vector3D(4d, 2d, -4d);
    assertThat(v1.length(), is(6d));

    Vector3D v2 = new Vector3D(1d, -2d, -2d);
    assertThat(v2.length(), is(3d));
}