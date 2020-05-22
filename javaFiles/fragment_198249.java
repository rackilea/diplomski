public void webClick(View v) 
        {
            switch(v.getId())
            {
            case R.id.button1:
                Intent intent = new Intent(this, Webview.class);
                intent.putExtra("weblink","file:///android_asset/chapter/chapter1.html");
                startActivity(intent);
                break;

.
.
.
.
            default:
            break;
            }
         }