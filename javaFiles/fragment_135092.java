public class MainActivity extends ActionBarActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ArrayList<Model> mydata = new ArrayList<Model>();
            // set 1
            Model model = new Model();
            ArrayList<String> points = new ArrayList<String>();
            model.setHeading("Manufactures");
            points.add("Google");
            points.add("Samsung");
            model.setPoints(points);
            mydata.add(model);

            // set 2

            model = new Model();
            points = new ArrayList<String>();
            model.setHeading("Platforms");
            points.add("Kitkat");
            points.add("ICS");
            model.setPoints(points);
            mydata.add(model);

            // String str =
            // "<h4>An Unordered List:</h4><br/>&#8226; foo<br/>&#8226; bar<br/>&#8226; baz<br/>";

            TextView textview = (TextView) findViewById(R.id.myText);
            String result = "";
            for (int i = 0; i < mydata.size(); i++) {
                result += "<h4>" + mydata.get(i).getHeading() + "</h4>";
                ArrayList<String> appendPoints = new ArrayList<String>(mydata
                        .get(i).getPoints());
                for (int j = 0; j < appendPoints.size(); j++){
                    result += "&#8226; " + appendPoints.get(j) + "<br/>";}

            }

            Spanned spannedResult = Html.fromHtml(result);

            textview.setText(spannedResult);

        }

    }