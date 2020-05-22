@Mock private ClassOne mockClassOne; // Don't call `mock`; let @Mock handle it.
@Mock private ClassTwo mockClassTwo;
@Mock private ClassThree mockClassThree;

@Override public void setUp() {
  MockitoAnnotations.initMocks(this); // Inits fields having @Mock, @Spy, and @Captor.
  when(mockClassOne.getClsTwo()).thenReturn(mockClassTwo);
  when(mockClassTwo.getClsThree()).thenReturn(mockClassThree);

  // Now that you can get to mockClassThree, you can stub that too.
  when(mockClassThree.loadFileFromAssetStore("Default value")).thenReturn(...);
  when(mockClassThree.loadFileFromAssetStore("Your expected filename")).thenReturn(...);
}