override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    holder.itemView.textViewSelectMedicineName.text = medicineList.get(position)

    holder.itemView.checkboxSelectMedicine.setOnCheckedChangeListener(null)
    if(selectedCheckBoxMedicineList.contains(itemText)) {
        holder.itemView.setChecked(true)
    } else {
        holder.itemView.setChecked(false)
    }

    holder.itemView.checkboxSelectMedicine.setOnCheckedChangeListener { buttonView, isChecked ->
            val itemText = medicineList.get(position)



        if (isChecked) {
            selectedCheckBoxMedicineList.add(itemText)

        } else {
            selectedCheckBoxMedicineList.remove(itemText)
        }


    }
}

fun restoreSelectedMedicineList(selectedCheckBoxMedicineList: ArrayList<String>) {
    this.selectedCheckBoxMedicineList = selectedCheckBoxMedicineList
    notifyDataSetInvalidated()        
}