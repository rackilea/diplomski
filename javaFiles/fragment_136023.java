if( (!currentEmpty || !finalEmpty) || (!current2Empty || !final2Empty)) {

        if(finalEmpty) {
            tv_current.setText(et_current.getText());
        }
        else {
            tv_final.setText(et_final.getText());
        }

        if(final2Empty) {
            tv_current2.setText(et_current2.getText());
        }
        else {
            tv_final2.setText(et_final2.getText());
        }
    }