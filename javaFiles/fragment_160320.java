import com.some.ContactsPresenter;
import dagger.android.support.DaggerFragment;

public class ContactsFragment extends DaggerFragment {

    @Inject
    ContactsPresenter mContactsPresenter;

    // .....
}