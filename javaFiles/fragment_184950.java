@Mock PermissionsChecker mockPermissionsChecker;
@Mock BluetoothAdapterWrapper mockBluetoothAdapterWrapper;
@Mock ScanningView mockScanningView;

//system under test
ScanningPresenter scanningPresenter;

@Before
public void setUp() {
    MockitoAnnotations.init(this);
    scanningPresenter = new ScanningPresenter(mockScanningView, mockPermissionsChecker, mockBluetoothAdapterWrapper);
}

@Test
public void shouldDisplayBluetoothRequestWhenDisabled() {
    //arrange
    when(mockBluetoothAdapter.isEnabled()).thenReturn(false);

    //act
    mScanningPresenter.startScanning();

    //assert
    verify(mockScanningView).displayDialogRequestingBluetooth();
}