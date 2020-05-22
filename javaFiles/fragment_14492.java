@SuppressWarnings("deprecation")
@Override
public void onDestroy()
{
    super.onDestroy();
    System.runFinalizersOnExit(true);
    System.exit(0);
}