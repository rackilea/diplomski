private void seekBarAction() {

    seekbar = (SeekBar) findViewById(R.id.seekBar);
    seekbar.setOnSeekBarChangeListener(
            new SeekBar.OnSeekBarChangeListener() {
                //int seekBarProgressValue = 0;

                //SwitchColor switchColor = new SwitchColor(topSqr,seekBarProgressValue,"#FFF","#000");
               // switchColor.SwitchTextViewBackground(); // cannot resolve Symbol

                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //seekBarProgressValue = i;
                //Edit is here 
                SwitchColor switchColor = new SwitchColor(topSqr,i,"#FFFFFF","#000000");
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }

            }
    );

}}