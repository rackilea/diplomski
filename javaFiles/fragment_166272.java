public class MyLocaleViewHandler extends ViewHandler {

    private final ViewHandler base;


    @Override
    public Locale calculateLocale(FacesContext context) {
      //fetch the session scoped bean and return the
      LocaleBean bean = (LocaleBean ) context.getExternalContext().getRequest().getSession().getAttribute("locale");//this line is not tested.
      return locale;
    }
      //other stuff..


    }