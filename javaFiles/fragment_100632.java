@RunWith(JukitoRunner.class) 
public class PersonsPagePresenterTest {
    PersonPagePresenter personPagePresenter;

    @Before
    public void setUp(PersonPagePresenter personPagePresenter) {
        this.personPagePresenter = Mockito.spy(personPagePresenter);
    }

    @Test
    public void testAddPersonClick() {
        personPagePresenter.onAddPersonClick();

        Mockito.verify(personPagePresenter).addToPopupSlot(editPersonPresenter);
    } 
}