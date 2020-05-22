@InverseBindingMethods({
     InverseBindingMethod(type = CustomControl.class, attribute="vm")})
public class CustomCtrl extends View {
    private CustomCtrlBinding binding;
    private InverseBindingAdapter listener;

    public CustomCtrl(...) {
        binding = ...
        binding.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
            @Overriide
            public void OnPropertyChanged(Observable sender, int propertyId) {
                if (listener != null) {
                    listener.onChange();
                }
            }
        });
    }

    @Bindable
    public boolean getVm() { return binding.getItem(); }

    public void setVm(boolean vm) {
        binding.setItem(vm);
    }

    @BindingAdapter("vmAttrChanged")
    public static void setListener(CustomCtrl view,
            InverseBindingListener listener) {
        view.listener = listener;
    }
}