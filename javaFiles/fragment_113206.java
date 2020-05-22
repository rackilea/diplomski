private String description;
private Date dueDate;
private Priority priority;
private boolean isToggled;
....
public ToDoItem(String desc) {
    description = desc;
    dueDate = null;
    priority = priority.HIGH;
    isToggled = false;
}
....
public void setToggle(boolean toggled) {
    isToggled = toggled;
}
public boolean isToggled() {
    return isToggled;
}