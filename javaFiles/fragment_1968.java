@AddressAnnotation 
public class Address {
    @NotNull @Max(50) private String street1;
    @Max(50) private String street2;
    @Max(10) @NotNull private String zipCode;
    @Max(20) @NotNull String city;
    @NotNull private Country country;

    ...
}

@Constraint(validatedBy = MultiCountryAddressValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddressAnnotation {
    String message() default "{error.address}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}

public class MultiCountryAddressValidator implements ConstraintValidator<AddressAnnotation, Address> {
    public void initialize(AddressAnnotation constraintAnnotation) {
    // initialize the zipcode/city/country correlation service
    }

    /**
     * Validate zipcode and city depending on the country
     */
    public boolean isValid(Address object, ConstraintValidatorContext context) {
        if (!(object instanceof Address)) {
            throw new IllegalArgumentException("@Address only applies to Address");
        }
        Address address = (Address) object;
        Country country = address.getCountry();
        if (country.getISO2() == "FR") {
            // check address.getZipCode() structure for France (5 numbers)
            // check zipcode and city correlation (calling an external service?)
            return isValid;
        } else if (country.getISO2() == "GR") {
            // check address.getZipCode() structure for Greece
            // no zipcode / city correlation available at the moment
            return isValid;
        }
        // ...
    }
}