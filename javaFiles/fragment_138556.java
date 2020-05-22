if(value == 0)
    {
        RadioButton radioButton = new RadioButton(mMain);
        radioButton.setText(name_price);
        radioButton.setId(i + 6);
        radioButton.setTextSize(12);
        radioButton.setTag(attributes.get(num));
        radioButton.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
        {
            radioButton.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        }
        setTextFont(radioButton, "Museo_Slab.otf");

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f);
        lp.setMargins(10, 10, 0, 10); // llp.setMargins(left, top, right, bottom);

        radioButton.setLayoutParams(lp);

        attr_layout[j].addView(radioButton);
        num++;

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                try
                {
                    ItemAttributes itemAttributes = (ItemAttributes) buttonView.getTag();

                    if (isChecked)
                    {

                        float total_price = current_price + attr_price;

                        item.setItemPrice(total_price + "");

                        item_price_text.setText(priceStr);

                        selectedAttributes.add(itemAttributes);
                    }
                    // If the attributes are not checked

                } catch (Exception ex)
                {
                    GSLogger.e(ex);
                }
            }
        });
    }

    if(value==1)
    {
        CheckBox checkBox = new CheckBox(mMain);
        checkBox.setText(name_price);
        checkBox.setId(i + 6);
        checkBox.setTextSize(12);
        checkBox.setTag(attributes.get(num));
        checkBox.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
        {
            checkBox.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        }
        setTextFont(checkBox, "Museo_Slab.otf");

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f);
        lp.setMargins(10, 10, 0, 10); // llp.setMargins(left, top, right, bottom);

        checkBox.setLayoutParams(lp);

        attr_layout[j].addView(checkBox);
        num++;

        // Reads the value depending on attribute User Selects
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                try
                {
                    ItemAttributes itemAttributes = (ItemAttributes) buttonView.getTag();

                    if (isChecked)
                    {

                        float total_price = current_price + attr_price;

                        item.setItemPrice(total_price + "");

                        item_price_text.setText(priceStr);
                        selectedAttributes.add(itemAttributes);
                    }

                } catch (Exception ex)
                {
                    GSLogger.e(ex);
                }
            }
        });
    }