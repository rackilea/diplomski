public class InputFilterMinMax implements InputFilter {

    private Float min, max;

    public InputFilterMinMax(Float min, Float max) {
        this.min = min;
        this.max = max;
    }

    public InputFilterMinMax(String min, String max) {
        this.min = Float.parseFloat(min);
        this.max = Float.parseFloat(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            Float input = Float.parseFloat(dest.toString() + source.toString());
            String inputValue = (dest.toString() + source.toString());
            if (isInRange(min, max, input, inputValue)) return null;
        } catch (NumberFormatException nfe) {
        }
        return "";
    }

    private boolean isInRange(Float min, Float max, Float input, String inputValue) {
        if (inputValue.contains(".") && (inputValue.split("\\.").length > 1)) {
            return (max > min ? input >= min && input <= max : input >= max && input <= min) && (inputValue.split("\\.")[1].length() < 3);
        } else {
            return (max > min ? input >= min && input <= max : input >= max && input <= min);
        }
    }
}