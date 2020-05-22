@VaadinUI
@Theme('app')
@CompileStatic
class AppUI extends UI {

    final static String K1 = 'keyframe1'
    final static String K2 = 'keyframe2'

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final layout = new VerticalLayout()
        layout.setSpacing(true)
        layout.setMargin(true)
        final headline = new Label('Hello World')
        headline.addStyleName(K1)
        final button = new Button("toggle", {
            if (headline.styleName.contains(K1)) {
                headline.addStyleName(K2)
                headline.removeStyleName(K1)
            } else {
                headline.addStyleName(K1)
                headline.removeStyleName(K2)
            }
        } as Button.ClickListener)
        layout.addComponents(headline, button)
        setContent(layout)
    }

}