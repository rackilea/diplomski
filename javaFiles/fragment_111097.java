for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
     dayKeys.add(snapshot.getKey());
}
List<String> days = new ArrayList<>();
for (int i = 0, dayKeysSize = dayKeys.size(); i < dayKeysSize; i++) {
     String day = dayKeys.get(i);
     days.add(day);
     Collections.sort(days, dateComparator);
}
for (String sortedDay : days) {
     if ("Monday".equals(sortedDay)) {
         mondayBundle.putString(SCHEDULE_DAY, "Monday");
         monday.setArguments(mondayBundle);
         viewPagerAdapter.addFragment(monday, "Monday");
         viewPagerAdapter.notifyDataSetChanged();
     }
     if ("Tuesday".equals(sortedDay)) {
         tuesdayBundle.putString(SCHEDULE_DAY, "Tuesday");
         tuesday.setArguments(tuesdayBundle);
         viewPagerAdapter.addFragment(tuesday, "Tuesday");
         viewPagerAdapter.notifyDataSetChanged();
     }
     if ("Wednesday".equals(sortedDay)) {
         wednesdayBundle.putString(SCHEDULE_DAY, "Wednesday");
         wednesday.setArguments(wednesdayBundle);
         viewPagerAdapter.addFragment(wednesday, "Wednesday");
         viewPagerAdapter.notifyDataSetChanged();
     }
     if ("Thursday".equals(sortedDay)) {
         thursdayBundle.putString(SCHEDULE_DAY, "Thursday");
         thursday.setArguments(thursdayBundle);
         viewPagerAdapter.addFragment(thursday, "Thursday");
         viewPagerAdapter.notifyDataSetChanged();
     }
     if ("Friday".equals(sortedDay)) {
         fridayBundle.putString(SCHEDULE_DAY, "Friday");
         friday.setArguments(fridayBundle);
         viewPagerAdapter.addFragment(friday, "Friday");
         viewPagerAdapter.notifyDataSetChanged();
     }
     if ("Saturday".equals(sortedDay)) {
         saturdayBundle.putString(SCHEDULE_DAY, "Saturday");
         saturday.setArguments(saturdayBundle);
         viewPagerAdapter.addFragment(saturday, "Saturday");
         viewPagerAdapter.notifyDataSetChanged();
     }
     if ("Sunday".equals(sortedDay)) {
         sundayBundle.putString(SCHEDULE_DAY, "Sunday");
         sunday.setArguments(sundayBundle);
         viewPagerAdapter.addFragment(sunday, "Sunday");
         viewPagerAdapter.notifyDataSetChanged();
     }
}