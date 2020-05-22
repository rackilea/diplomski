public class GetInfo extends AsyncTask<ReisData, Integer, String> {
ReisData data;
Reisplanner reisPlanner;
View view;

public GetInfo(Reisplanner main,ReisData data) {
this.data=data;// you can use this
this.reisPlanner = main;

view = reisPlanner.getView();
}

@Override
protected void onPreExecute() {
ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
progressBar.setVisibility(View.VISIBLE);
super.onPreExecute();

}
@Override
protected String doInBackground(ReisData... params) {
try {
    // Return XML as string with route options
    return HttpRequestHelper.downloadFromServer(params);
} catch (MalformedURLException e) {
    e.printStackTrace();
}
return null;
}

@Override
protected void onPostExecute(String result) {
super.onPostExecute(result);

DocumentBuilder builder;
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

Document doc = null;

try {
    builder = factory.newDocumentBuilder();
    doc = builder.parse(new InputSource(new StringReader(result)));
} catch (Exception e) {
    e.printStackTrace();
}

// TODO: Get 'ReisData' object

if (doc != null) {
    XMLParser.parse(doc);
}

// Start Reisadvies with ReisData class
Fragment fragment = new Reisadvies();

// TODO: Put ReisData class into Bundle

this.reisPlanner.startFragment(fragment);

}