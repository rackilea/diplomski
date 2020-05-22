listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     @Override
 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Model model= (Model) wisataAdapter.getItem(position);

                if(position==0){
                   Intent intent = new Intent(GunungKidul.this, Pantai_Kesirat.class);
                   //To pass whole model data with intent:
                   intent.putExtra("MyClassKey", model);
                   startActivity(intent);
                }
                else if{
                    Intent intent = new Intent(GunungKidul.this,  Goa_Pindul.class);
                    //To pass whole model data with intent:
                    intent.putExtra("MyClassKey", model);
                    startActivity(intent);
                }
        else if{
                    Intent intent = new Intent(GunungKidul.this, Pantai_Baron.class);
                    //To pass whole model data with intent:
                    intent.putExtra("MyClassKey", model);
                    startActivity(intent);
                }
        else if{
                    Intent intent = new Intent(GunungKidul.this, Goa_Jomblang.class);
                    //To pass whole model data with intent:
                    intent.putExtra("MyClassKey", model);
                    startActivity(intent);
                }
        else if{
                    Intent intent = new Intent(GunungKidul.this, AirTerjun.class);
                    //To pass whole model data with intent:
                    intent.putExtra("MyClassKey", model);
                    startActivity(intent);
                }



                            }
                        })

;