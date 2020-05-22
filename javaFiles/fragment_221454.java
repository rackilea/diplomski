String url ="indirizzo"+ MainActivity.codschool.getText().toString()+"&login="+MainActivity.id.getText().toString()+"&password="+MainActivity.pw.getText().toString();
            Connection.Response res = Jsoup
                    .connect("url")

                    .data("login", MainActivity.id.getText().toString())
                    .data("password",MainActivity.pw.getText().toString())
                    .method(Connection.Method.POST)
                    .execute();

            //Keep logged in
            Map<String, String> cookies = res.cookies();