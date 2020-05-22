package com.kkoci.shairlook;

/**
* Created by kristian on 02/07/2015.
*/
import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.appspot.shairlook1.userEndpoint.UserEndpoint;
import com.appspot.shairlook1.userEndpoint.model.User;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, List<User>> implements GoogleClientRequestInitializer{
private static UserEndpoint myApiService = null;
private Context context;

EndpointsAsyncTask(Context context) {
    this.context = context;
}

@Override
public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
 // put it here no in MyClass
 abstractGoogleClientRequest.setDisableGZipContent(true);
}

// class MyClass{} // you don't need it


@Override
protected List<User> doInBackground(Void... params) {
    if(myApiService == null) { // Only do this once
        UserEndpoint.Builder builder =  new UserEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
// options for running against local devappserver
// - 10.0.2.2 is localhost's IP address in Android emulator
// - turn off compression when running against local devappserver
                .setRootUrl("http://localhost:8080/_ah/api/")
                .setGoogleClientRequestInitializer(this);
// end options for devappserver

        myApiService = builder.build();
    }

    try {
        return myApiService.listUser().execute().getItems();
    } catch (IOException e) {
        return Collections.EMPTY_LIST;
    }
}

@Override
protected void onPostExecute(List<User> result) {
    for (User q : result) {
        Toast.makeText(context, q.getWho() + " : " + q.getWhat(), Toast.LENGTH_LONG).show();
    }
}
}