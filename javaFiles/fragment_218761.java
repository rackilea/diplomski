import com.google.gwt.resources.client.CssResource;

public interface MyCssResource extends CssResource {

    @ClassName("myCssClassName") String myCssClassName();

    @ClassName("myOtherName") String myOtherCssClassName();
}