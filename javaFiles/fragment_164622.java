final EditText editText1 = (EditText) findViewById(R.id.editText1);
        editText1.setText("1,200.40");

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int arg1, int arg2,
                    int arg3) {
                insertCommaIntoNumber(editText1,s);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                    int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

private void insertCommaIntoNumber(EditText etText,CharSequence s)
    {
        try {
            if (s.toString().length() > 0) 
            {
                String convertedStr = s.toString();
                if (s.toString().contains(".")) 
                {
                    if(chkConvert(s.toString()))
                        convertedStr = customFormat("###,###.##",Double.parseDouble(s.toString().replace(",","")));
                } 
                else
                {
                    convertedStr = customFormat("###,###.##", Double.parseDouble(s.toString().replace(",","")));
                }

                if (!etText.getText().toString().equals(convertedStr) && convertedStr.length() > 0) {
                    etText.setText(convertedStr);
                    etText.setSelection(etText.getText().length());
                }
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public String customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        return output;
    }

    public boolean chkConvert(String s)
    {
        String tempArray[] = s.toString().split("\\.");
        if (tempArray.length > 1) 
        {
            if (Integer.parseInt(tempArray[1]) > 0) {
                return true;
            }
            else 
                return false;
        }
        else
            return false;
    }