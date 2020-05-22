if (selectedPosition == position) {
            holder.mRadioButton.setChecked(true);

          yourList.get(position).setRadioButton(holder.mRadioButton.isChecked)
            notifyDataSetChanged();
        } else {
            holder.mRadioButton.setChecked(false);
         yourList.get(position).setRadioButton(holder.mRadioButton.isChecked)
            notifyDataSetChanged();
        }