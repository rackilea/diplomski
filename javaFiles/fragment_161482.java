for( Triple triple: acros2){
            currAc = mEdit.getText().toString();
            if(triple.contains(currAc)){
                Intent intent1 = new Intent(view.getContext(), ValidAcronym.class);
                view.getContext().startActivity(intent1);
            }

     }
        Intent intent2 = new Intent(view.getContext(), InvalidAcronym.class);
        view.getContext().startActivity(intent2);