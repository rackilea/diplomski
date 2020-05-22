public class GenericBinderComposite<T extends Enum<?> & HasDisplayText> extends Composite {

   private static GenericBinderCompositeUiBinder uiBinder = GWT.create(GenericBinderCompositeUiBinder.class);
   interface GenericBinderCompositeUiBinder extends UiBinder<Widget, GenericBinderComposite<?>> {}   

   private T enumClass;

   public GenericBinderComposite() {
      initWidget(uiBinder.createAndBindUi(this));
   }
   public T getEnumClass() {
      return enumClass;
   }
   public void setEnumClass(T enumClass) {
      this.enumClass = enumClass;
   }

}