public class test extends Activity {
    LinearLayout layout;
    Button btnarr [] = new Button[50];
    int counter = 0,check=0;
    protected void onCreate(Bundle savedInstanceState) {
        counter=0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

                layout = new LinearLayout(this);
                layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                layout.setOrientation(LinearLayout.VERTICAL);

        File sdcard = Environment.getExternalStorageDirectory();

        //Get the text file
        File file = new File(sdcard,"yourbuttonname.txt");

        //Read text from file
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                btnarr[counter] = new Button(this);
                btnarr[counter].setText(text.toString());
                text = new StringBuilder();
                counter++;
                check++;
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        doit();
    }
    public void doit()
    {
        counter = 0;
        while(counter < check)
        {
            LinearLayout row = new LinearLayout(this);
            row.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            btnarr[counter].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            row.addView(btnarr[counter]);
            layout.addView(row);
            counter++;
        }
        setContentView(layout);
    }
}