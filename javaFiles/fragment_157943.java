public int getItemViewType(int position) {
   if (modelList.get(position).IfSingleLine())
        return VERTICAL;
    else {
        return HORIZONTAL;
    }
}`