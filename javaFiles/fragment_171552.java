public class BindingUtils
  {
       @BindingAdapter({"bind:selection"})
       public static void setSelection(Spinner spinner, int position)
       {
            spinner.setSelection(position);
       }
  }