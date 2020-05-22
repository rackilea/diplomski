String content;
            content = subject.getText().toString();
           list.add(content);
            ArrayAdapter dataAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item, list);

            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner1.setAdapter(dataAdapter);