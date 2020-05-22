if (totalMonths > 0 && days < 0) {
        totalMonths--;
        LocalDate calcDate = this.plusMonths(totalMonths);
        days = (int) (end.toEpochDay() - calcDate.toEpochDay());  // safe
    } else if (totalMonths < 0 && days > 0) {
        totalMonths++;
        days -= end.lengthOfMonth();