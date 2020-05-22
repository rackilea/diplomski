package wat.core.plugin;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.swt.widgets.Composite;

public class SmartComboFieldEditor extends ComboFieldEditor {

    public SmartComboFieldEditor(String name, String labelText, String[][] entryNamesAndValues, Composite parent) {
        super(name, labelText, entryNamesAndValues, parent);
    }

    public String getSelectedValue()
    {
        doStore();
        return getPreferenceStore().getString(getPreferenceName());
    }

    public void setSelectedValue(String newValue)
    {
        getPreferenceStore().setValue(getPreferenceName(), newValue);
        doLoad();
    }
}