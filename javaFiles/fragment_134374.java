import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Music extends Fragment {

Button bttnKevin, bttnLecrae, bttnLuke;
// bttnSkillet, bttnSoMo, bttnHunter;
MediaPlayer mpKevin, mpLecrae, mpLuke, mpSkillet, mpSoMo, mpHunter;
int playing;

Button.OnClickListener bKevin = new Button.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (playing) {
        case 0:
            mpKevin.start();
            playing = 1;
            bttnKevin.setText("Pause");
            bttnLecrae.setVisibility(View.INVISIBLE);
            bttnLuke.setVisibility(View.INVISIBLE);
            // bttnSoMo.setVisibility(View.INVISIBLE);
            // bttnHunter.setVisibility(View.INVISIBLE);
            // bttnSkillet.setVisibility(View.INVISIBLE);
            break;
        case 1:
            mpKevin.pause();
            playing = 0;
            bttnKevin.setText("Play");
            bttnLecrae.setVisibility(View.VISIBLE);
            bttnLuke.setVisibility(View.VISIBLE);
            // bttnSoMo.setVisibility(View.VISIBLE);
            // bttnHunter.setVisibility(View.VISIBLE);
            // bttnSkillet.setVisibility(View.VISIBLE);
            break;
        }
    }
};
Button.OnClickListener bLecrae = new Button.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (playing) {
        case 0:
            mpLecrae.start();
            playing = 1;
            bttnLecrae.setText("Pause");
            bttnKevin.setVisibility(View.INVISIBLE);
            bttnLuke.setVisibility(View.INVISIBLE);
            // bttnSoMo.setVisibility(View.INVISIBLE);
            // bttnHunter.setVisibility(View.INVISIBLE);
            // bttnSkillet.setVisibility(View.INVISIBLE);
            break;
        case 1:
            mpLecrae.pause();
            playing = 0;
            bttnLecrae.setText("Play");
            bttnKevin.setVisibility(View.VISIBLE);
            bttnLuke.setVisibility(View.VISIBLE);
            // bttnSoMo.setVisibility(View.VISIBLE);
            // bttnHunter.setVisibility(View.VISIBLE);
            // bttnSkillet.setVisibility(View.VISIBLE);
            break;
        }
    }
};
Button.OnClickListener bLuke = new Button.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (playing) {
        case 0:
            mpLuke.start();
            playing = 1;
            bttnLuke.setText("Pause");
            bttnKevin.setVisibility(View.INVISIBLE);
            bttnLecrae.setVisibility(View.INVISIBLE);
            // bttnSoMo.setVisibility(View.INVISIBLE);
            // bttnHunter.setVisibility(View.INVISIBLE);
            // bttnSkillet.setVisibility(View.INVISIBLE);
            break;
        case 1:
            mpLuke.pause();
            playing = 0;
            bttnLuke.setText("Play");
            bttnKevin.setVisibility(View.VISIBLE);
            bttnLecrae.setVisibility(View.VISIBLE);
            // bttnSoMo.setVisibility(View.VISIBLE);
            // bttnHunter.setVisibility(View.VISIBLE);
            // bttnSkillet.setVisibility(View.VISIBLE);
            break;
        }
    }
};
Button.OnClickListener bSkillet = new Button.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (playing) {
        case 0:
            mpSkillet.start();
            playing = 1;
            // bttnSkillet.setText("Pause");
            bttnKevin.setVisibility(View.INVISIBLE);
            bttnLecrae.setVisibility(View.INVISIBLE);
            // bttnSoMo.setVisibility(View.INVISIBLE);
            // bttnHunter.setVisibility(View.INVISIBLE);
            bttnLuke.setVisibility(View.INVISIBLE);
            break;
        case 1:
            mpSkillet.pause();
            playing = 0;
            // bttnSkillet.setText("Play");
            bttnKevin.setVisibility(View.VISIBLE);
            bttnLecrae.setVisibility(View.VISIBLE);
            // bttnSoMo.setVisibility(View.VISIBLE);
            // bttnHunter.setVisibility(View.VISIBLE);
            bttnLuke.setVisibility(View.VISIBLE);
            break;
        }
    }
};
Button.OnClickListener bSoMo = new Button.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (playing) {
        case 0:
            mpSoMo.start();
            playing = 1;
            // bttnSoMo.setText("Pause");
            bttnKevin.setVisibility(View.INVISIBLE);
            bttnLecrae.setVisibility(View.INVISIBLE);
            // bttnSkillet.setVisibility(View.INVISIBLE);
            // bttnHunter.setVisibility(View.INVISIBLE);
            bttnLuke.setVisibility(View.INVISIBLE);
            break;
        case 1:
            mpSoMo.pause();
            playing = 0;
            // bttnSoMo.setText("Play");
            bttnKevin.setVisibility(View.VISIBLE);
            bttnLecrae.setVisibility(View.VISIBLE);
            // bttnSkillet.setVisibility(View.VISIBLE);
            // bttnHunter.setVisibility(View.VISIBLE);
            bttnLuke.setVisibility(View.VISIBLE);
            break;
        }
    }
};
Button.OnClickListener bHunter = new Button.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (playing) {
        case 0:
            mpHunter.start();
            playing = 1;
            // bttnHunter.setText("Pause");
            bttnKevin.setVisibility(View.INVISIBLE);
            bttnLecrae.setVisibility(View.INVISIBLE);
            // bttnSkillet.setVisibility(View.INVISIBLE);
            // bttnSoMo.setVisibility(View.INVISIBLE);
            bttnLuke.setVisibility(View.INVISIBLE);
            break;
        case 1:
            mpHunter.pause();
            playing = 0;
            // bttnHunter.setText("Play");
            bttnKevin.setVisibility(View.VISIBLE);
            bttnLecrae.setVisibility(View.VISIBLE);
            // bttnSkillet.setVisibility(View.VISIBLE);
            // bttnSoMo.setVisibility(View.VISIBLE);
            bttnLuke.setVisibility(View.VISIBLE);
            break;
        }
    }
};




@Override
public View onCreateView(LayoutInflater inflater,
        @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.activity_music, container, false);
}

@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    bttnKevin = (Button) view.findViewById(R.id.bttnKevin);
    bttnLecrae = (Button) view.findViewById(R.id.bttnLecrae);
    bttnLuke = (Button) view.findViewById(R.id.bttnLuke);
    // bttnSkillet = (Button)findViewById(R.id.bttnSkillet);
    // bttnSoMo = (Button)findViewById(R.id.bttnSoMo);
    // bttnHunter = (Button)findViewById(R.id.bttnHunter);

    bttnKevin.setOnClickListener(bKevin);
    bttnLecrae.setOnClickListener(bLecrae);
    bttnLuke.setOnClickListener(bLuke);
    // bttnSkillet.setOnClickListener(bSkillet);
    // bttnSoMo.setOnClickListener(bSoMo);
    // bttnHunter.setOnClickListener(bHunter);

    mpKevin = new MediaPlayer();
    mpKevin = MediaPlayer.create(getActivity(), R.raw.meow);
    mpLecrae = new MediaPlayer();
    mpLecrae = MediaPlayer.create(getActivity(), R.raw.dog_barking_sound);
    mpLuke = new MediaPlayer();
    mpLuke = MediaPlayer.create(getActivity(), R.raw.meow);
    mpSkillet = new MediaPlayer();
    mpSkillet = MediaPlayer.create(getActivity(), R.raw.dog_barking_sound);
    mpSoMo = new MediaPlayer();
    mpSoMo = MediaPlayer.create(getActivity(), R.raw.meow);
    mpHunter = new MediaPlayer();
    mpHunter = MediaPlayer.create(getActivity(), R.raw.dog_barking_sound);

    playing = 0;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    // noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
        return true;
    }

    return super.onOptionsItemSelected(item);
  }
}