float prev;
...
if (prev != current / finalSize * 100) {
  prev = current / finalSize * 100;
  UpdatePercentNotificationBar((int) prev);
}