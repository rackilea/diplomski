for (Volunteer volunteer : volunteers) {
    int oldHours = volunteer.getHours();
    int newHours = oldHours + 8;

    volunteer.setHours(newHours);
}