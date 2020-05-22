case 1:
case 3:
case 5:
case 7:
case 8:
case 10:
case 12:
    totalDays = 31;
    break;
case 2:
    if (((yearInt % 4 == 0) && !(yearInt % 100 == 0))
            || (yearInt % 400 == 0))
        totalDays = 29;
    else
        totalDays = 28;
    break;
default:
    totalDays = 30;
    break;