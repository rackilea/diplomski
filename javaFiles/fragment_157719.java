holder.name.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        db_build.open();
                        RadioButton name = (RadioButton) v;
                        AvailableBuildings building = (AvailableBuildings) name.getTag();
                        Log.e( "Available: ", ""+building.getAvailable_title()+building.getAvailable_code());
                        Log.e( "Available: ", ""+db_build.insertTitle(1, building.getAvailable_title(), aiksteles_link, curdid, 0, 1, building.getAvailable_type(), "3", building.getAvailable_code()));
                        db_build.close();
                        dia.dismiss();
                    }
                });