List<VocabWord>words1 = db.getAllVocabWords();
     switch(words1.get(position).getCategory())
        {
        case 0:
            holder.defaultButton.setChecked(true);
            break;

        case 1:
            holder.redButton.setChecked(true);
            break;

        case 2:
            holder.yellowButton.setChecked(true);
            break;


        case 3:
            holder.greenButton.setChecked(true);
            break;

        }

    holder.radiogroupView.setFocusable(false);
    holder.radiogroupView.setFocusableInTouchMode(false);