public class MyMainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
         super(savedInstanceState);
         setContentView(R.layout.my_empty_layout);

         ReportCard myFirstReportCard = new ReportCard("SO College", "Mr. Kooijman", "2016", "aylin", 80, 72, 55);
         int socialStudiesGrade = myFirstReportCard.getSocialStudiesGrade();
    }
}