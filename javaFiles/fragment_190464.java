@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    private Presenter sut;

    @Mock
    private View view;
    @Captor
    private ArgumentCaptor<ViewTouchedListener> listenerCaptor;
    private ViewTouchedListener listener;

    @Before
    public void setUp() {
        sut = new Presenter(view);

        verify(view).addViewTouchedListener(listenerCaptor.capture());

        listener = listenerCaptor.getValue();
    }

    // test methods have access to both sut and its registered listener
}