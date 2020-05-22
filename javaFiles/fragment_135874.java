submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fKeyboardClose();

                textstring(phone, login, pass);
                prefwrite(editor);
                pushurl();
                clear(phone, login, pass);