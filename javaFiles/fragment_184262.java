if (f.exists()==true) {
        f.delete();
       FileOutputStream fos = getActivity().openFileOutput(location, Context.MODE_PRIVATE);
        fos.write(codebox.getText().toString().getBytes());
        fos.close();
   }