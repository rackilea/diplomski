Clip clipA = AudioSystem.getClip();
Clip clipB = AudioSystem.getClip();
clipA.open(aisA);
clipB.open(aisB);

for (int i = 0; i < 100; i ++) {
   FloatControl gainControlA = (FloatControl) clipA.getControl(FloatControl.Type.MASTER_GAIN);
   gainControlA.setValue(i * -1f);
   FloatControl gainControlB = (FloatControl) clipB.getControl(FloatControl.Type.MASTER_GAIN);
   gainControlB.setValue(-100f + i);

   Thread.sleep(100);
}