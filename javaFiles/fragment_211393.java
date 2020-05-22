timePrev = timeNext
timeNext = (h%12)*60+m

if (abs(timePrev-timeNext)<halfOfCircle){
    if (timePrev<timeNext){
        return "CW"
    } else {
        return "CCW"
    }
} else {
    if (timeNext<halfOfCircle){
        return "CW"
    } else {
        return "CCW"
    }
}