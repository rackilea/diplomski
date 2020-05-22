private Date startDate; // getter and setter
private Date endDate;   // getter and setter

@Validations(
    customValidators={
        @CustomValidator(type="compareDatesValidator", 
            message="Dates provided are not valid."
            parameters={
                @ValidationParameter(name="fromDate", value="${startDate}"), 
                @ValidationParameter(name="toDate",   value="${endDate}")})})
public String execute(){
    return SUCCESS;
}