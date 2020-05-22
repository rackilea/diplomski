package validator;

import actions.DiscountAction;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.ValidatorSupport;
import org.joda.time.DateTime;

public final class DiscountDateValidator extends ValidatorSupport
{
    private String startDate; //Set to ${discountStartDate}
    private String endDate;   //Set to ${discountEndDate}

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public void validate(Object o) throws ValidationException
    {
        DateTime discountStartDate = (DateTime)parse(startDate, DateTime.class);
        DateTime discountEndDate = (DateTime)parse(endDate, DateTime.class);

        System.out.println("startDate = "+discountStartDate);
        System.out.println("endDate = "+discountEndDate);
        System.out.println((o instanceof DiscountAction));

        //Perform validation as required using these values.
    }
}