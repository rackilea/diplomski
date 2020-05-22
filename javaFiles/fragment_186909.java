@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:

                String title = titleText.getText().toString();
                String desc = descText.getText().toString();

                dbManager.update(_id, title, desc);
                this.returnHome();
                break;   //missing break statement

            case R.id.btn_complete:
                titleText.setText( "Marked Complete" + completeBtn.getText());
                complete();
                break;

            case R.id.btn_delete:
                dbManager.delete(_id);
                this.returnHome();
                break;
        }
    }

    public void complete(){
        String title = titleText.getText().toString();
        String desc = descText.getText().toString();

        dbManager.update(_id, title, desc);
    }