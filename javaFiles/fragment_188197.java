// EDIT #1: Create a hashtable to lookup stuff:
final Hashtable<String, String> vals = new Hashtable<String, String>();

      for(int i = 0; i < ItemArrayName.length; i++)
      {
         vals.put(ItemArrayName[i], ItemArrayName[i] + "\nAtk = " + String.valueOf(ItemArrayAtk[i]) + ", Def = " + String.valueOf(ItemArrayDef[i]));
      }

      Spinner spnItem = (Spinner) view.findViewById(R.id.UseItem);
      // EDIT #2: Extract the array of hash keys to show in your list:
      ArrayAdapter<String> adpItem = new ArrayAdapter<String> context, R.layout.spinnerrow, vals.keySet().toArray(new String[vals.size()]));
      spnItem.setAdapter(adpItem);
      spnItem.setOnItemSelectedListener(new OnItemSelectedListener()
      {
         public void onItemSelected(AdapterView<?> parent, View view, int position, long arg3)
         {
            // EDIT #3: retrieve the full string from the hashtable using "get":
            String city = "The item is " + vals.get(parent.getItemAtPosition(position).toString());
            //Toast.makeText(parent.getContext(), city, Toast.LENGTH_LONG).show();
         }

         public void onNothingSelected(AdapterView<?> arg0)
         {
            // TODO Auto-generated method stub
         }
      });