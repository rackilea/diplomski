try {
            URL url = new URL(imageUrl);
            HttpGet httpRequest = null;

            httpRequest = new HttpGet(url.toURI());

            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = (HttpResponse) httpclient.execute(httpRequest);

            HttpEntity entity = response.getEntity();
            BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);
            InputStream input = bufHttpEntity.getContent();

            Bitmap bitmap = BitmapFactory.decodeStream(input);

            ImageActivity.this.i.setImageBitmap(bitmap);
            ImageActivity.this.i.refreshDrawableState();
            input.close();

        } catch (MalformedURLException e) {
            Log.e("ImageActivity", "bad url", e);
        } catch (Exception e) {
            Log.e("ImageActivity", "io error", e);
        }