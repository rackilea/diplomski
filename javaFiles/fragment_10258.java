String filename = "android.resource://" + this.getPackageName() + "/raw/test0";

mp = new MediaPlayer();
try { mp.setDataSource(this,Uri.parse(filename)); } catch (Exception e) {}
try { mp.prepare(); } catch (Exception e) {}
mp.start();