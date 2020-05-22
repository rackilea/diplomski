public class BeanValidator {

    /**
     * Used to validate an order request and all the attached objects that
     * support validation.
     * 
     * @param request
     * @throws ConstraintViolationException
     */
    public static <T> void validate(T request) throws ConstraintViolationException {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<T>> constraintViolations = validator.validate(request);
            if (constraintViolations.size() > 0) {
                    throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(constraintViolations));
            }
    }
}


@XmlRootElement
public class Customer {

    @NotNull(message = "spCustomerID1 is a required field")
    @Size(max = 60, message = "spCustomerID1 has a max length of 60 characters")
    private String spCustomerID1;

    @Size(max = 60, message = "spCustomerID2 has a max length of 60 characters")
    private String spCustomerID2;

    @Size(max = 60, message = "spCustomerID3 has a max length of 60 characters")
    private String spCustomerID3;

    @NotNull(message = "customerName is a required field")
    @Size(max = 60)
    private String customerName;

    @Valid
    @NotNull(message = "customerAddress is a required field")
    private PostalAddress customerAddress;

    @Valid
    @NotNull(message = "customerContact is a required field")
    private ContactInfo customerContact;

    @Valid
    @NotNull(message = "technicalContact is a required field")
    private ContactInfo technicalContact;
    ... / Getters and Setters
}