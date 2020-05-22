int prev;
...
if (prev != (int)(current / finalSize * 100)) {
  prev = (int)(current / finalSize * 100);
  UpdatePercentNotificationBar(prev);
}