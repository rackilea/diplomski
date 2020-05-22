public class MyFormvalidator implements Validator
{
    private List<String> fileFormats;

    public MyFormValidator(List<String> fileFormats) {
        this.fileFormats = fileFormats;
    }

... //the rest of your validator, including checks for fileFormats.contains(myForm.getFormat())