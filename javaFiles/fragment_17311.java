package info.magnolia.test.field.validator;

import info.magnolia.ui.form.validator.definition.ConfiguredFieldValidatorDefinition;

public class SizeFieldsValidatorDefinition extends ConfiguredFieldValidatorDefinition {
    public SizeFieldsValidatorDefinition() {
        setFactoryClass(SizeFieldsValidatorFactory.class);
    }
}


package info.magnolia.test.field.validator;

import info.magnolia.context.Context;
import info.magnolia.ui.form.validator.factory.AbstractFieldValidatorFactory;

import com.vaadin.data.Item;
import com.vaadin.data.Validator;

public class SizeFieldsValidatorFactory extends AbstractFieldValidatorFactory<SizeFieldsValidatorDefinition> {
    private final Item item;
    private final Context context;

    public SizeFieldsValidatorFactory(final SizeFieldsValidatorDefinition definition, final Item item, final Context context) {
        super(definition);

        this.item = item;
        this.context = context;
    }

    public Validator createValidator() {
        return new SizeFieldsValidator(item, context, getI18nErrorMessage());
    }
}


package info.magnolia.test.field.validator;

import info.magnolia.context.Context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.data.Item;
import com.vaadin.data.validator.AbstractStringValidator;

public class SizeFieldsValidator extends AbstractStringValidator {

    private final Item item;
    private final Context context;

    public SizeFieldsValidator(final Item item, final Context context, final String errorMessage) {
        super(errorMessage);

        this.item = item;
        this.context = context;
    }

    @Override
    protected boolean isValidValue(String text1) {
        if (!StringUtils.isEmpty(text1)) {
            return checkit(text1);
        }

        return false;
    }

    private boolean checkit(String text1) {
        // the atomic pattern '[number,number]':
        Pattern atom = Pattern.compile("\\[\\d+\\s?\\,\\s?\\d+\\]");

        // must start with '[' and end with ']' in all cases:
        Pattern pattern = Pattern.compile("^\\[(.*)\\]$");
        Matcher matcher = pattern.matcher(text1);
        if (!matcher.matches()) {
            return false;
        }

        // the bit inside the required outer '[' and ']':
        String data = matcher.group(1);

        // now check that the bits inside follow the plan:
        if (!Pattern.matches("\\d+\\s?\\,\\s?\\d+", data) && !Pattern.matches("(" + atom + "\\s?\\,?\\s?){1,}", data)) {
            // ^ bare numbers                                // ^ multiple objs
            return false;
        }

        return true;
    }
}