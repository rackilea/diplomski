public void submit_btn(){
    AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {


        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading Please Wait!!");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Integer... integers) {

            if (data.size() == 0) {
                Toast.makeText(MainActivity.this, "Your List Is Empty Please Fill First", Toast.LENGTH_SHORT).show();
            } else {

                for (int i = 0; i < data.size(); i++) {
                    HashMap<String, Object> obj = (HashMap<String, Object>) listView.getAdapter().getItem(i);
                    a = (String) obj.get("A");
                    s = (String) obj.get("B");
                    cc = (String) obj.get("C");

                    try {
                        Connection con = connectionClass.CONN();
                        if (con == null) {
                            Toast.makeText(getApplicationContext(), "Error in connection with SQL server", Toast.LENGTH_LONG).show();
                        } else {

                            try {
                                con = connectionClass.CONN();
                                if (con == null) {
                                    Toast.makeText(getApplicationContext(), "Error in connection with SQL server", Toast.LENGTH_LONG).show();

                                } else {
                                    String query = "SELECT AccessionNo FROM suigen.TransAlmiraShelf WHERE AccessionNo='" + String.valueOf(cc) + "'";
                                    Statement stmt = con.createStatement();
                                    ResultSet rs = stmt.executeQuery(query);
                                    while (rs.next()) {
                                        ppp3.add(rs.getString("AccessionNo"));


                                        StringBuilder builder3 = new StringBuilder();
                                        for (String value : ppp3) {
                                            builder3.append(value);
                                        }
                                        accno1 = builder3.toString();
                                    }
                                }
                            } catch (Exception ex) {
                                Toast.makeText(getApplicationContext(), "Exceptions", Toast.LENGTH_LONG).show();
                            }
                            if (cc.equals(accno1)) {
                                try {
                                    con = connectionClass.CONN();
                                    if (con == null) {
                                        Toast.makeText(getApplicationContext(), "Error in connection with SQL server", Toast.LENGTH_LONG).show();
                                    } else {
                                        String query = "UPDATE suigen.TransAlmiraShelf SET Almira='"+String.valueOf(a)+"',Shelf='"+String.valueOf(s)+"' WHERE AccessionNo='" + cc + "'";
                                        Statement stmt = con.createStatement();
                                        stmt.execute(query);
                                    }
                                } catch (Exception ex) {
                                    Toast.makeText(getApplicationContext(), "Exceptions", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                String query = "INSERT INTO suigen.TransAlmiraShelf (Almira, Shelf, AccessionNo) VALUES('" + String.valueOf(a) + "','" + String.valueOf(s) + "','" + String.valueOf(cc) + "')";
                                Statement stmt = con.createStatement();
                                stmt.execute(query);

                            }
                        }
                    } catch (Exception ex) {
                        Toast.makeText(getApplicationContext(), "Exceptions", Toast.LENGTH_LONG).show();
                    }
                }
            }
          return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.cancel();

            Toast.makeText(MainActivity.this, "Your Data Successfully Saved", Toast.LENGTH_LONG).show();
            almirah.setText("");
            shelf.setText("");
            accession_no.setText("");
            finish();
            startActivity(getIntent());

        }
    };
    task.execute();

}