public class NumericRangeValidationService
{
    @Text( "{0} is smaller than the minimum allowed value ({1})" )
    private static LocalizableText smallerThanMinimumMessage;

    @Text( "{0} is larger than the maximum allowed value ({1})" )
    private static LocalizableText largerThanMaxiumMessage;

    static
    {
        LocalizableText.init( NumericRangeValidationService.class );
    }

    ...
}