query.getFirstInBackground(new GetCallback() {
        public void done(ParseObject frat, ParseException e) {
            if (e != null && frat != null) {
                frat = put("FratScore", Integer.parseInt(frat.getString("FratScore")) + intScore4);
                frat.saveInBackground();
            } else {
                Log.w("No Frat Found!!");
        }