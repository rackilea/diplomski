import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;

public abstract class TrackedFragment extends Fragment{

     private Tracker tracker;

     @Override
     public void onActivityCreated(final Bundle savedInstanceState) {

         super.onActivityCreated(savedInstanceState);

         this.tracker = EasyTracker.getInstance(getActivity());
     }

     @Override
     public void onResume() {

         super.onResume();

         this.tracker.set(Fields.SCREEN_NAME, getClass().getSimpleName());
         this.tracker.send( MapBuilder.createAppView().build() );
     }
}