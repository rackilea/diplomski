import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyDialog extends Dialog implements View.OnClickListener {


    public MyDialog(Context context) {
        super(context);
    }

    Button myBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog);

        myBtn = findViewById(R.id.my_btn);
        myBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == myBtn) {
            Toast.makeText(view.getContext(), "clicked", Toast.LENGTH_SHORT).show();
        }
    }
}