//declare it here (regardless this "initial" value)
boolean valueExists = false;
for (Entry<String, List<Bean>> entry: courseMap.entrySet()) {
    //initialize it here
    valueExists = false;
    //...
    for (Bean resultBean : entry.getValue()) {
        if(course_date.equalsIgnoreCase(resultBean.getCourseDate()){
            valueExists = true;
            //also, add a break here since you already found the value
            //you don't need to keep iterating through the rest of items
            break;
        }
    }
    if (valueExists) {
        //...
    }
}