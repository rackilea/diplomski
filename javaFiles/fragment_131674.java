holder.checkBox.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(holder.checkBox.isChecked()) {
                myChecked.add(DataIpat.measureEviArray.get(position));
            }
            else {
                myChecked.remove(DataIpat.measureEviArray.get(position));
            }
            for (int i=0; i<myChecked.size(); i++){
                MeasureEvi e= myChecked.get(i);
                Log.d("mOrder", String.valueOf(e.getmOrderIndex()));
            }
        }
    });