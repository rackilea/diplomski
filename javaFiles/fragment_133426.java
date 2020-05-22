package savovuksan.at.noteit; 
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;`

public class NotizOeffnungsMenue extends Activity implements View.OnClickListener {


public Button[] NoteListBtn; //just declare as members
public String[] NoteList;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_notiz_oeffnungs_menue);

    //initialiaze
    NoteListBtn = new Button[fileList().length]; 
    NoteList = fileList();

    for (int i = 0;i<fileList().length;i++)
    {
        NoteListBtn[i] = new Button(this);
        NoteListBtn[i].setText(NoteList[i]);
        NoteListBtn[i].setOnClickListener(this);
    }





}

}