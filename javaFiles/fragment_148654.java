String end;
if (jTimeButton3 != null && jTimeButton3.getTargetDate() != null) {
    SimpleDateFormat dateFormatTime2 = new SimpleDateFormat("hh:mm a");
    end = dateFormatTime2.format(jTimeButton3.getTargetDate());
    endTime.setText(end);
} else {
    JOptionPane.showMessageDialog(
            null, "Please select a End Time.");

    return;
}