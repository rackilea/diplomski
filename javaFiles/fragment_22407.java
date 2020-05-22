final String js = "javascript: " +
                "var nameDoc = document.getElementsByName('name');" +
                "nameDoc[0].value = '"+n+ "';" +
                "var checkOutDoc = document.getElementsByName('checkout');" +
                "checkOutDoc[0].value = '"+btn_co+ "';" +
                "var noOFPaxDoc = document.getElementsByName('no_of_pax');" +
                "noOFPaxDoc[0].value = '"+a+ "';" + // a should be int based on ur HTML
                "var noOFKidDoc = document.getElementsByName('no_of_kid');" +
                "noOFKidDoc[0].value = '"+k+ "';" + // a should be int based on ur HTML
                "var noOFRoomsDoc = document.getElementsByName('no_of_rooms');" +
                "noOFRoomsDoc[0].value = '"+r+ "';" + // a should be int based on ur HTML
                "var checkInDoc = document.getElementsByName('checkin');" +
                "checkInDoc[0].value = '"+btn_ci+ "';";

        if (Build.VERSION.SDK_INT >= 19) {
            view.evaluateJavascript(js, new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String s) {

                }
            });
        } else {
            view.loadUrl(js);
        }