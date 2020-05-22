public boolean isEarlier(Task argTask) {
    if(this.date.isEarlier(argTas.date)) {
        return true;
    } else if(argTask.date.isEarlier(this.date)) {
        return false;
    } else if(this.time.isEarlier(argTask.time)) { //reached if date fields are equal
        return true;
    }

    //At this stage, either `argTask.time.isEarlier(this.time)` returns true
    //or date and time in both objects are exactly equal
    return false;
}