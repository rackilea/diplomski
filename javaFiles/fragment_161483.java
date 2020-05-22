boolean flag = true;
      for( Triple triple: acros2){
            currAc = mEdit.getText().toString();
            if(triple.contains(currAc)){
                Intent intent1 = new Intent(view.getContext(), ValidAcronym.class);
                view.getContext().startActivity(intent1);
                flag = false;
                break;
            }
      }
        Intent intent2 = new Intent(view.getContext(), InvalidAcronym.class);
        if(flag){
            view.getContext().startActivity(intent2);
        }