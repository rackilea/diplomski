private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
        throws ValidationException
    {
        if (value == null)
        {
            if (isNullAllowed)
            {
                // return; // null permitted, nothing to validate
            }
            else
            {
                throw new ValidationException(String.format("%s cannot be null", fieldName));
            }
        }
        else ...
    }