@ManagedBean
@ViewScoped
public class Profile {

    List<Picture> pictures;

    public Profile() {
        pictures = new ArrayList<Picture>();

        for (int i = 0; i < Constants.MAX_NUM_OF_PICTURES; i++) {
            pictures.add(new Picture());
        }
    }

    // ...
}