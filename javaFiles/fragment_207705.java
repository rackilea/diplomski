@Override
    protected void onPostExecute(Document document) {
        if (document != null) {
            Elements imgElements = document.select("img");
            List<String> images = new ArrayList<>();

            for (Element element : imgElements) {
                String image = element.attr("data-src");
                Log.d("IMAGE_URL", image);
                if(image!=null && !image.equals("")){
                    images.add(image);
                }
            }

            String[] imgArray = images.toArray(new String[images.size()]);
            ViewPagerAdapter adapter = new ViewPagerAdapter(MainActivity.this, imgArray);
            viewPager.setAdapter(adapter);
        }
    }