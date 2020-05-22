iDate = iDate.minusYears(1);
switch (iDate.getDayOfWeek()) {
    case 1:
        // monday so no change
        break;
    case 2:
        iDate = iDate.minusDays(1);
        break;
    case 3:
        iDate = iDate.minusDays(2);
        break;
    ...
}