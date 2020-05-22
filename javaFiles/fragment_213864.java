private boolean isLeapYear(inYear){
    if((inYear % 100 == 0) && (inYear % 400 != 0))
    {
        return false;
    }else if(inYear % 4 == 0)
    {
        return true;
    }else{
        return false;
    }
}

private int getNewMonthCode(inYear, inMonthCode) {
    if (isLeapYear(inYear)) {
        return inMonthCode-1;
    }
    return inMonthCode;
}

public int getMonthCode(inYear, inMonth) {
    // variable to store the code
    int monthCode;

    // Check which month uses which month code
    switch (inMonth){
        case JANUARY_INT: monthCode = getNewMonthCode(inYear, JAN_CODE);
            break;
        case FEBURARY_INT: monthCode = getNewMonthCode(inYear, FEB_CODE);
            break;
        case MARCH_INT: monthCode = MAR_CODE;
            break;
        case APRIL_INT: monthCode = APR_CODE;
            break;
        case MAY_INT: monthCode = MAY_CODE;
            break;
        case JUNE_INT: monthCode = JUN_CODE;
            break;
        case JULY_INT: monthCode = JUL_CODE;
            break;
        case AUGUST_INT: monthCode = AUG_CODE;
            break;
        case SEPTEMBER_INT: monthCode = SEP_CODE;
            break;
        case OCTOBER_INT: monthCode = OCT_CODE;
            break;
        case NOVEMBER_INT: monthCode = NOV_CODE;
            break;
        case DECEMBER_INT: monthCode = DEC_CODE;
            break;
        default: monthCode = 0;
    }
    return monthCode;
}