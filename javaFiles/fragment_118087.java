String str = "999";
    DecimalFormat f = null;
    if (abs_d < 1000) {
        if (abs_d < 1) {
            f = new DecimalFormat("@@");
            str = f.format(d);
        }
        else {
            f = new DecimalFormat("@@@");
            str = f.format(d);
        }
    }

    my_text_view.setText(str);