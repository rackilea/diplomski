import java.util.Observable;
import java.util.Observer;

public class ModeChangeObserver extends Activity implements Observer{

    private ModeObject mode = new ModeObject();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle);
        mode.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        switch(((ModeObject)o).GetMode())
        {
            case IDLE:
                break;
            case NEW:
                break;
            case VIEW:
                break;
            case EDIT:
                break;
        }
    }
}