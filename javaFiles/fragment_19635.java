@Override
        public void afterTextChanged(Editable s) {
             try{
                qty = Integer.valueOf(s.toString()).intValue();
             }catch(Exception e){
               ///
             }
        }