public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Log.d(TAG,"Here is Spinner Calling,Value is "+My_Spinner.getSelectedItem().toString());
Toast.makeText(getActivity(), " Here Your Text For Toast  ", Toast.LENGTH_SHORT).show();    
      }
         @Override
            public void onNothingSelected(AdapterView<?> parent) {
Toast.makeText(getActivity(), " Here Your Text For Nothing Selected Toast  ", Toast.LENGTH_SHORT).show();

            }