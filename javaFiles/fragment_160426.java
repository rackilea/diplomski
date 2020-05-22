public void read(){
        if(i < words.length){
          txt.setText(words[i]);
          i++;
          handler.postDelayed(rnb, interval);
       }
    }