m_btn = (Button)findViewById(R.id.button);
        m_edt = (EditText)findViewById(R.id.type);
        m_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            try {
                session.send(m_edt.getText().toString());
                m_edt.setText("");

            } catch (OmegleException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            }
        });