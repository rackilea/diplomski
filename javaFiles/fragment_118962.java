public class CustomTextView extends TextView {
   @Inject
   AnyProvider anyProvider;

   public CustomTextView(Context context) { this(context, null); }
   public CustomTextView(Context AttributeSet attrs) { 
      super(context, attrs);
      Application.getComponent(context).inject(this);
   }
}