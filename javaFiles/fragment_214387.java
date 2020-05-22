@Override
public void onDestroy()
 {
    super.onDestroy();

    int id= android.os.Process.myPid();
    android.os.Process.killProcess(id);
 }