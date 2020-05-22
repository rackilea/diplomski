import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
public class STT 
{
    Activity theCallerActivity;
    static final int THREE_RESULTS=3;


boolean audioOk=true;
boolean clienOk=true;
boolean networkOk=true;
boolean matchOk=true;
boolean serverOk=true;

private static final int VOICE_RECOGNITION_REQUEST_CODE = 9999;

public STT(Activity activity)
{
    theCallerActivity=activity;
}

public boolean isVoiceRecognitionAvailable() // Check if voice recognition is present
{  
    PackageManager pm = theCallerActivity.getPackageManager();
    List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
    if (activities.size() == 0) 
        return false;
    return true;     
}
public void speak()  
{
    final Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
    intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, THREE_RESULTS);
    new Thread()
    {
        public void run()
        {
            theCallerActivity.startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
        }
    }.start();
}

public String toPerformInOnActivityResult(int requestCode,int resultCode,Intent data)
{
    ArrayList<String> textMatchList;

    if (requestCode == VOICE_RECOGNITION_REQUEST_CODE)
    {
        if(resultCode == Activity.RESULT_OK)
        {
             textMatchList=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);


            if (!textMatchList.isEmpty())
            {
                return textMatchList.get(0);

            }
            else if(resultCode == RecognizerIntent.RESULT_AUDIO_ERROR)
                audioOk=false;
            else if(resultCode == RecognizerIntent.RESULT_CLIENT_ERROR)
                clienOk=false;
            else if(resultCode == RecognizerIntent.RESULT_NETWORK_ERROR)
                networkOk=false;
            else if(resultCode == RecognizerIntent.RESULT_NO_MATCH)
                matchOk=false;
            else if(resultCode == RecognizerIntent.RESULT_SERVER_ERROR)
                serverOk=false;

        }

    }
    return null;
}