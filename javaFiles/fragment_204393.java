for (Reminder r : reminders) {

        String reminderType = r.getType();
        if(reminderType.equalsIgnoreCase(strType)) {

            Titles.add(r.getTitle());
            Type.add(reminderType);
            IDList.add(r.getID());
        }
    }