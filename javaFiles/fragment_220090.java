realm.executeTransactionAsync(new Realm.Transaction() {
        @Override
        public void execute(Realm bgRealm) {
            String csvFile = "longevity.csv";
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";
            try {
                br = new BufferedReader(new InputStreamReader(getAssets().open(csvFile)));
                Word user = new Word();
                while((line = br.readLine()) != null) {
                    // use comma as separator
                    final String[] oneWord = line.split(cvsSplitBy);
                    user.setWord(oneWord[1]);
                    user.setMeaning(oneWord[2]);
                    user.setSynonyms(oneWord[3]);
                    bgRealm.insert(user);
                }
            } catch(Throwable e) {
                e.printStackTrace();
                throw e;
            } finally {
                if(br != null) {
                    try {
                        br.close();
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }, new Realm.Transaction.OnSuccess() {
        @Override
        public void onSuccess() {
            Log.v("TAGGED", "SAVED");
        }
    }, new Realm.Transaction.OnError() {
        @Override
        public void onError(Throwable error) {
            Log.v("TAGGED", "FAILED");
        }
    });