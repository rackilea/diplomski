radiogroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                case R.id.ps4:
                     Log.d(getClass().getName(), "Plateforme_Choix =ps4");
                    break;
                case R.id.xbox:
                    Log.d(getClass().getName(), "Plateforme_Choix =xbox");
                    break;
                case R.id.pc:
                    Log.d(getClass().getName(), "Plateforme_Choix =pc");
                    break;
                }
            }
        });