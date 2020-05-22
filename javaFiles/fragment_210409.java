import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.InternationalFormatter;
import java.text.DateFormat;
import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateSpinner extends JSpinner {

    private static final long serialVersionUID = 1L;
    public DefaultFormatter _formatter;
    public DateEditor _timeEditor;
    public DateFormat _format;

    public DateSpinner() {
        this("hh:mm:ss");
    }

    public DateSpinner(String format) {
        this(format, new Date());
    }

    public DateSpinner(String format, Date date) {
        super(new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY));
        setFormat(format);
        customizeSpinner();
    }

    private void customizeDateEditor() {
        JFormattedTextField.AbstractFormatter formatter = _timeEditor.getTextField().getFormatter();
        if (formatter instanceof DefaultFormatter) {
            _formatter = (DefaultFormatter) formatter;
        } else {
            throw new IllegalStateException("The formatter is not an instance of DefaultFormatter.");
        }
        if (formatter instanceof InternationalFormatter) {
            Format f = ((InternationalFormatter) formatter).getFormat();
            if (f instanceof DateFormat) {
                _format = ((DateFormat) f);
            }
        }
        if (_format == null) {
            throw new IllegalStateException("The format is not an instance of SimpleDateFormat.");
        }
    }

    private void setFormat(String format) {
        _timeEditor = createDateEditor(format);
        customizeDateEditor();
        setEditor(_timeEditor);
    }

    private void customizeSpinner() {
        setLenient(false);
        setCommitsOnValidEdit(true);
        setAllowsInvalid(false);
        setOverwriteMode(true);
    }

    protected DateEditor createDateEditor(String format) {
        return new DateEditor(this, format);
    }

    public void setCommitsOnValidEdit(boolean commit) {
        _formatter.setCommitsOnValidEdit(commit);
    }

    public boolean getCommitsOnValidEdit() {
        return _formatter.getCommitsOnValidEdit();
    }

    public void setOverwriteMode(boolean overwriteMode) {
        _formatter.setOverwriteMode(overwriteMode);
    }

    public boolean getOverwriteMode() {
        return _formatter.getOverwriteMode();
    }

    public void setAllowsInvalid(boolean allowsInvalid) {
        _formatter.setAllowsInvalid(allowsInvalid);
    }

    public boolean getAllowsInvalid() {
        return _formatter.getAllowsInvalid();
    }

    public void setTimeZone(TimeZone zone) {
        _format.setTimeZone(zone);
    }

    public TimeZone getTimeZone() {
        return _format.getTimeZone();
    }

    public void setLenient(boolean lenient) {
        _format.setLenient(lenient);
    }

    public boolean isLenient() {
        return _format.isLenient();
    }
}