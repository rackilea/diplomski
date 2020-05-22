boolean activityExists;
if(testIntent.resolveActivity(pm) != null) {
    activityExists = true;
} else {
    activityExists = false;
}