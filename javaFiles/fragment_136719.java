_colorenotifica.setTag(position);
 _colorenotifica.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     int position = (int)v.getTag();
                    _popupcontainer = (ViewGroup)_inflater.inflate(R.layout.color_picker_popup,null);
                    _puw = new PopupWindow(_popupcontainer,800,600,true);//view,dimensioni e focusable
                    _btn_applica = (Button) _popupcontainer.findViewById(R.id.color_picker_btn_applica);
                    _tv_applica_colore = (TextView) _popupcontainer.findViewById(R.id.color_picker_tv);
                    _tv_applica_colore.setText(_sofosapps.get(position).get_app_name());
                    _lss = (LobsterShadeSlider)_popupcontainer.findViewById(R.id.color_picker_ls);
                    _puw.showAtLocation(_popupcontainer, Gravity.CENTER, 20, 50);
                    _btn_applica.setTag(position);
                    Log.d("DEBUG","I clicked on imagebutton and opened my popupwindow");
                }
            });
 _btn_applica.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    newcolor = _lss.getColor();
                    String dbg = "color = " + String.valueOf(newcolor);
                    Log.d("DEBUG", dbg);
                    int position = (int)v.getTag();
                    _sofosapps.get(position).setColor(dbg);
                    notifyDataSetChanged();
                    _puw.dismiss();
                }
            });