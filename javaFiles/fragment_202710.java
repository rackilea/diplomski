// If the time is negative make it a positive
long currentHourEST;
if (offSetAdded > 0) {
 currentHourEST = offSetAdded * -1;
} else {
 currentHourEST = offSetAdded;
}