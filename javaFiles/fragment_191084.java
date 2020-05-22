@Test
public void testGetScreenParams() throws Exception {
    // Arrange
    DisplayProvider mockDisplay = mock(DisplayProvider.class);
    BuildProvider mockBuild = mock(BuildProvider.class);        
    DeviceInfoProvider deviceInfoProvider = new DeviceInfoProvider(mockDisplay, mockBuild);

    when(mockDisplay.widthPixels).thenReturn(1081);
    when(mockDisplay.heightPixels).thenReturn(1921);
    when(mockBuild.Model).thenReturn(Build.MODEL);

    // Act
    DeviceInfo deviceInfo = deviceInfoProvider.getScreenParams();

    // Assert
    assertThat(deviceInfo.screenWidth, equalTo(1081));
    assertThat(deviceInfo.screenHeight, equalTo(1921));
    assertThat(deviceInfo.model, equalTo(Build.MODEL));
}