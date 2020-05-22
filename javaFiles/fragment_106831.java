public class AddressPresenterTest {

    @Mock
    private AddressView mView;

    @Mock
    private AddressDataSource mDataSource;

    @Mock
    private AddressLocalDataSource mLocalDataSource;

    @Captor
    ArgumentCaptor<DataSourceCallback<Province>> mProvinceCallbackCaptor;

    private AddressPresenter mPresenter;

    @Before
    public void beforeTest() throws Exception {
        MockitoAnnotations.initMocks(this);

        mPresenter = new AddressPresenter(mDataSource, mView);
        mPresenter.setLocalDataSource(mLocalDataSource);
    }

    @Test
    public void When_SelectProvince_DataIsNull_ShowErrorMessage() {
        mPresenter.getLocalProvinceById(2129023);

        // Cause data source has callback, we need to capture the callback
        ArgumentCaptor<Integer> provinceIdCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(mLocalDataSource).fetchProvinceById(provinceIdCaptor.capture(), mProvinceCallbackCaptor.capture());
        mProvinceCallbackCaptor.getValue().onFailedLoad();

        verify(mView).loadContentError();
    }
}