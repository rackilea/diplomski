UpdateUI updater;
public MyAsyntack (UpdateUI updater)
{
    this.updater = updater;
}
@Override
protected void onPostExecute(String result) 
{
    super.onPostExecute(result);
    updater.update();
}