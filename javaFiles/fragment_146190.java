public class CustomDialog extends Dialog implements OnClickListener {
TextView tvTitle;
TextView tvMessage;
Button btnOK;
ListView listView;
Context context;
ProgressBar prgWait;
ProgressBar prgBar;

public CustomDialog(Context context) {
    super(context, R.style.rtg_DialogActivity);
    setContentView(R.layout.dialog);
    this.context = context;

    // replace the background dim with a background blur effect
    WindowManager.LayoutParams lp = getWindow().getAttributes();
    lp.dimAmount = 0.0f;
    getWindow().setAttributes(lp);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);

    tvTitle = (TextView) findViewById(R.id.tvDialogTitle);
    tvMessage = (TextView) findViewById(R.id.tvDialogMessage);
    btnOK = (Button) findViewById(R.id.btnDialog);
    listView = (ListView) findViewById(R.id.lvDialogList);
    prgWait = (ProgressBar) findViewById(R.id.prgDialog);
    prgBar = (ProgressBar) findViewById(R.id.prgDialogBar);
}

public CustomDialog setTitle(String text) {
    tvTitle.setText(text);      
    return this;
}

public CustomDialog setMessage(String text) {
    tvMessage.setVisibility(View.VISIBLE);
    tvMessage.setText(text);        
    return this;
}

public CustomDialog setList(List<String> list, OnItemClickListener l) {
    ArrayAdapter<String> aa = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, list);
    listView.setVisibility(View.VISIBLE);
    listView.setAdapter(aa);
    listView.setOnItemClickListener(l);         
    return this;
}

public CustomDialog setList(String[] list, OnItemClickListener l) {
    List<String> lString = new ArrayList<String>();
    for (String s : list)
        lString.add(s);     
    return setList(lString, l);
}

public CustomDialog setButton(String text, View.OnClickListener l) {
    btnOK.setText(text);
    btnOK.setOnClickListener(l);
    return this;
}

public CustomDialog setButton(String text) {
    return setButton(text, this);
}

public CustomDialog isIndeterminate(boolean b) {
    if (b) {
        prgWait.setVisibility(View.VISIBLE);
        btnOK.setVisibility(View.GONE);
    } else {
        prgWait.setVisibility(View.GONE);
        btnOK.setVisibility(View.VISIBLE);
    }
    return this;
}

public CustomDialog isProgress(boolean b) {
    if (b) {
        prgBar.setVisibility(View.VISIBLE);
        btnOK.setVisibility(View.GONE);
    } else {
        prgBar.setVisibility(View.GONE);
        btnOK.setVisibility(View.VISIBLE);
    }
    return this;
}

public CustomDialog setProgressMax(int max) {
    prgBar.setMax(max);
    return this;
}

public CustomDialog setProgress(int progress) {
    prgBar.setProgress(progress);
    return this;
}

public int getProgressMax() {
    return prgBar.getMax();
}

public int getProgress() {
    return prgBar.getProgress();
}

@Override
public void onClick(View v) {
    this.dismiss();
}