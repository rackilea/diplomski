public class PersonGroup{
    private String name;
    private Date input;
    private Date output;
    private String value;

    public PersonGroup(String name, Date input, Date output, String value) {
        this.name = name;
        this.input = input;
        this.output = output;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonGroup that = (PersonGroup) o;

        if (input != null ? !input.equals(that.input) : that.input != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (output != null ? !output.equals(that.output) : that.output != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (input != null ? input.hashCode() : 0);
        result = 31 * result + (output != null ? output.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}