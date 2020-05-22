@Test
public void watcherShouldRingTheAlarmBellWhenOnFire() {
   AlarmBell alarm = mock(AlarmBell.class);
   FireWatcher watcher = new FireWatcher(alarm);

   watcher.onFire(1);

   verify(alarm).ring(2);
}