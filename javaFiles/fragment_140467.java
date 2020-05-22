(new Thread(){
        @Override public void run(){
            try {
                String rtoken = FirebaseInstanceId.getInstance().getToken();
                Log.v("tokken", rtoken);
                URL url = new URL("http://my website.com/yyy");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15001);
                conn.setConnectTimeout(15001);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("pid",jo.getString("parent_id"));
                conn.setRequestProperty("sid",jo.getString("parent_id"));
                conn.setRequestProperty("token",rtoken);
                conn.setDoOutput(true);

                OutputStream outputPost = new BufferedOutputStream(conn.getOutputStream());
                writeStream(outputPost);
                outputPost.flush();
                outputPost.close();


            } catch (ProtocolException e1) {
                e1.printStackTrace();
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }
}).start();