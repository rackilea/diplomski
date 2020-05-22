int i=0;
      for (Soldier soldier:clickedSquad.getMembers()) {
            soldier.setId(i++);
            RadioButton radiobutton=new RadioButton(getContext());
            radiobutton.setText(soldier.toString());
            radiobutton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            radiobutton.setId(soldier.getId());
            soldierRgrp.addView(radiobutton);
        }