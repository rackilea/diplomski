public class LoadSettings 
{
    public LoadSettings(Context ctx)
    {
        SharedPreferences sharedPreferences =
            ctx.getSharedPreferences("MY_SHARED_PREF", 0);
        String strSavedMem1 = sharedPreferences.getString("gSendTo", "");
        String strSavedMem2 = sharedPreferences.getString("gInsertInto", "");
        String cCalId = sharedPreferences.getString("gCalID", "");

        setInsertIntoStr(strSavedMem2);
        setSendToStr(strSavedMem1);
    }

    private String cSendToStr;
    private String cInsertIntoStr;
    private int cCalId;
    private Uri cCalendars;

    public String getSendToStr()
    {
       return cSendToStr;
    }

    public void setSendToStr(String pSendToStr)
    {
        cSendToStr = pSendToStr;
    }

    public String getInsertIntoStr()
    {
        return cInsertIntoStr;
    }

    public void setInsertIntoStr(String pInsertIntoStr)
    {
        cInsertIntoStr = pInsertIntoStr;
    }

}