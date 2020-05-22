if(getChildrenCount(groupPosition)>1){
                if(converterView == null || converterView.getClass() == RelativeLayout.class){
                    converterView = inflater.inflate(R.layout.menu_item, null);

TextView txtListChild = (TextView) convertView
                .findViewById(R.id.textoOpcion);

        txtListChild.setText(childText);
                }
            }
            else{
                if(converterView == null || converterView.getClass() == LinearLayout.class){
                    converterView = inflater.inflate(R.layout.empty_item, null);
                }
            }

return converterView;