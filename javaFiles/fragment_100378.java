package fields.factory;

import com.vaadin.data.Item;
import com.vaadin.ui.Field;
import fields.YourField;
import fields.definition.YourFieldDefinition;
import info.magnolia.objectfactory.ComponentProvider;
import info.magnolia.ui.api.app.AppController;
import info.magnolia.ui.api.context.UiContext;
import info.magnolia.ui.api.i18n.I18NAuthoringSupport;
import info.magnolia.ui.form.field.factory.AbstractFieldFactory;

import javax.inject.Inject;

public class YourFieldFactory extends AbstractFieldFactory<YourFieldDefinition, String> { // String is the type your component will work with
    private YourField yourField;

    private final AppController appController;
    private final UiContext uiContext;
    private ComponentProvider componentProvider;

    @Inject
    public YourFieldFactory(YourFieldDefinition definition, Item relatedFieldItem, UiContext uiContext, I18NAuthoringSupport i18nAuthoringSupport, AppController appController, ComponentProvider componentProvider) {
        super(definition, relatedFieldItem, uiContext, i18nAuthoringSupport);
        this.appController = appController;
        this.uiContext = uiContext;
        this.componentProvider = componentProvider;
    }

    @Override
    public void setComponentProvider(ComponentProvider componentProvider) {
        super.setComponentProvider(componentProvider);
        this.componentProvider = componentProvider;
    }

    @Override
    protected Field<String> createFieldComponent() { // Again: Your type
        yourField = new YourField(definition, componentProvider);
        return yourField;
    }
}