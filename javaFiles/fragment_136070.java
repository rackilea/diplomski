@Override
public void onBindViewHolder(@NonNull ContractsAdapter.ContractViewHolder holder, int position) {

    Contracts contract = contractsList.get(position);

    if (contract.getCurrentDate() > contract.getDateofexpiry()) {
        holder.dateofexpiry.setTextColor(Color.RED);
    }

    holder.dateofexpiry.setText(contract.getDateofexpiry());
}