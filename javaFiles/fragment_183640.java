override fun onBindViewHolder(holder: VM, position: Int) {
    val item = items.get(position)

    if (item.favourite == 0) {
        holder.name.text = item.name
    } else {
        holder.name.text = item.name + " Liked "
    }

    holder.favouriteIcon.setOnCheckedChangeListener { compoundButton, isChecked ->
        // Should not update local view reference here
        if(isChecked) {
            // Update the local reference object, Just not to update from DB
            item.favourite = 1
            // Do the logic to update the DB to add the item in Fav
        } else {
            // Update the local reference object, Just not to update from DB
            item.favourite = 0
            // Do the logic to update to remove the item from Fav list
        }
        notifyItemChanged(position) // Helps to update the particular item
    }
}