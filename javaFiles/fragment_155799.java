String html2 = "<img src=\"a.jpg\">";
    CharSequence text2 = Html.fromHtml(html2, new Html.ImageGetter(){
        public Drawable getDrawable(String source){
            String path = "/sdcard/a/" + source;
            File f = new File(path);
            Drawable bmp = Drawable.createFromPath(f.getAbsolutePath());
            bmp.setBounds(0, 0, bmp.getIntrinsicWidth(), bmp.getIntrinsicHeight());
            return bmp;
        }
    }, null);
    display.setText(text2);