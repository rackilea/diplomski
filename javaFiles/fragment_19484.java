private String text;

@DataBoundConstructor
public MyClass(EnableTextBlock enableText)
{
    if (enableText != null)
    {
        this.text = enableText.text;
    }
}

public static class EnableTextBlock
{
    private String text;

    @DataBoundConstructor
    public EnableTextBlock(String text)
    {
        this.text = text;
    }
}