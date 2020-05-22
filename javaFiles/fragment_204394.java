// Generate real data for each item
public List<ReminderItem> generateData(int count) {

    String strType = "Monthly";

    ArrayList<ReminderItem> items = new ArrayList<>();

    // Get all reminders from the database
    List<Reminder> reminders = rb.getAllReminders();

    // Initialize lists
    List<String> Titles = new ArrayList<>();
    List<String> Type = new ArrayList<>();
    List<Integer> IDList= new ArrayList<>();

    // Add details of all reminders which type="Monthly" in their respective lists
    for (Reminder r : reminders) {

        String reminderType = r.getType();
        if(reminderType.equalsIgnoreCase(strType)) {

            Titles.add(r.getTitle());
            Type.add(reminderType);
            IDList.add(r.getID());
        }
    }
    return items;
}