final Document[] doc = {null};

        final String url = "https://docs.google.com/spreadsheets/d/e/2PACX-1vRAS7DEUoTqv9gKNSTg9XrgktfqZs1vw3L-eivZW2UPCOeSqiqt8Xdtsd3o-tmS9m-uTHCYn8JbToAx/pubhtml";

        new AsyncTask<Void,Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    doc[0] = Jsoup.connect(url).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                List<Event> allEvents = new ArrayList<Event>();
                Element table = doc[0].select("table").get(0); //select the first table.
                Elements rows = table.select("tr");

                for (int i = 2; i < rows.size(); i++) { //first row is the col names so skip it, second is title.
                    Element row = rows.get(i);
                    Elements cols = row.select("td");
                    EventLog.Event hold = new EventLog.Event(cols.get(0).text(), cols.get(1).text(), cols.get(2).text(), cols.get(3).text());
                    allEvents.add(hold);
                }

                for (UsageEvents.Event x : allEvents) {
                    x.createDateTime();
                }

                LinearLayout linearLayout = new LinearLayout(SplashActivity.this);
                setContentView(linearLayout);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                for (int i = 0; i < allEvents.size(); i++) {
                    TextView textView = new TextView(SplashActivity.this);
                    textView.setText(allEvents.get(i).toString());
                    linearLayout.addView(textView);
                }
            }
        }.execute();