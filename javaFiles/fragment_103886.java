// in OnCreate

    Button mClickButton1 = (Button)findViewById(R.id.clickButton1);
    mClickButton1.setOnClickListener(this);
    Button mClickButton2 = (Button)findViewById(R.id.clickButton2);
    mClickButton2.setOnClickListener(this);
    Button mClickButton3 = (Button)findViewById(R.id.clickButton3);
    mClickButton3.setOnClickListener(this);

// somewhere else in your code

    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.clickButton1: {
            // launch ABOUT US webview.
            startWebViewActivity(MenuType.ABOUTUS);
                break;
            }

            case R.id.clickButton2: {
            // launch FAQS webview.
            startWebViewActivity(MenuType.FAQS);
                break;
            }

            case R.id.clickButton3: {
            // launch TERMSANDCONDITION webview.
            startWebViewActivity(MenuType.TERMSANDCONDITION);
                break;
            }

            default:
             break;
        }




// method triggered when button clicked
    private void startWebViewActivity(MenuType menuType) {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra(WebViewActivity.INTENT_MENUTYPE, menuType);
            startActivity(intent);
        }