public class YourActivity implements YourFragmentListener {

    @Override
    void onParksLoaded(List<String names) {
        // Do something with the names
        yourField.setText(names.get(0))
    }

}