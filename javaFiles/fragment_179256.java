for(int i = 0; i < jArray.length(); ++i){
JSONObject json_data = jArray.getJSONObject(i);

//                                      
String paskaita = json_data.getString("paskaita");
String laikas = json_data.getString("laikas");
String savaite = json_data.getString("savaite");                                        
String auditorija = json_data.getString("auditorija");
String destytojas = json_data.getString("destytojas");                                      
String dalykas = json_data.getString("dalykas");
String tipas = json_data.getString("tipas");

// Create a new view every time.
View Item = View.inflate(ln.getContext(), layoutID, null);


//Just adding view                              
TextView pask = (TextView) Item.findViewById(R.id.paskaita);
pask.setText(paskaita);

TextView laik = (TextView) Item.findViewById(R.id.laikas);
laik.setText(laikas);

TextView sav = (TextView) Item.findViewById(R.id.savaite);
sav.setText(savaite);

TextView dest = (TextView) Item.findViewById(R.id.destytojas);
dest.setText(destytojas);

TextView aud = (TextView) Item.findViewById(R.id.auditorija);
aud.setText(auditorija);

TextView dal = (TextView) Item.findViewById(R.id.dalykas);
dal.setText(dalykas);

TextView tip = (TextView) Item.findViewById(R.id.tipas);
tip.setText(tipas);

ln.addView(Item);