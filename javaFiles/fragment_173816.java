fun Date.truncateTimeFromDate() {
  Calendar calendar = Calendar.getInstance()

  calendar.setTime(this)

  calendar.set(Calendar.HOUR_OF_DAY, 0)
  calendar.set(Calendar.MINUTE, 0)
  ...
}