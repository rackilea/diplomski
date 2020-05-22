Element divimg = imgsdiv.getElementsByClass("lazy img-responsive").first();

                if ( divimg==null)
                    {
                    Log.e(TAG, "divimg==null: " + titolo);

                    immaginiart.add(null);                      
                    }
                else
                {
                String imgSrc = divimg.attr("src");
                InputStream input = new java.net.URL(imgSrc).openStream();
                bitmap = BitmapFactory.decodeStream(input);
                immaginiart.add(bitmap);
                }