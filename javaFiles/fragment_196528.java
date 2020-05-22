//...
while ((line = br.readLine()) != null) {
    String[] values = line.split("\t");
    //To ensure it's still valid data
    if (values.length >= 1 && values.length <= 2) {
        String addedTask = values[0];
        String enteredDueDate;
        //Check whether dueDate has a value or is empty
        if (values.length == 1)
            enteredDueDate = "";
        else
            enteredDueDate = values[1];
        DueDate d = new DueDate(addedTask, enteredDueDate);
        tasks.add(d);
    }
}
//...