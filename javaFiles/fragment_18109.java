public class MainActivityTest {

    @Before
    public void setup() {
        Robolectric.buildActivity(MainActivity.class).create();
    }

    @Test
    public void testToastMessage() {
        ToastLayoutBinding binding = DataBindingUtil.getBinding(ShadowToast.getLatestToast().getView());
        binding.executePendingBindings();

        assertEquals(binding.toastMsg.getContext().getString(R.string.some_toast),
                binding.toastMsg.getText());
    }

    @Test
    public void testToastDuration() {
        assertEquals(Toast.LENGTH_LONG, ShadowToast.getLatestToast().getDuration());
    }
}