public class Trade {
    private LocalDate startDate ;
    private LocalDate endDate ;
    … 

    // Getters
    public LocalDate getStartDate() { 
        return this.startDate ;
    }
    public LocalDate getEndDate() { 
        return this.endDate;
    }
    public Period getPeriod() {  // Number of years-months-days elapsed.
        return Period.between( this.startDate , this.endDate ) ;
    }

    // Setters
    public void setStartDate( LocalDate startDateArg ) { 
        this.startDate = startDateArg ;
    }
    public void setEndDate( LocalDate endDateArg ) { 
        this.endDate = endDateArg ;
    }

    @Override
    public toString() {
        "Trade={ " + "startDate=" + this.startDate.toString() …
    }
…
}