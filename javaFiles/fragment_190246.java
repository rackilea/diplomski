budgetPeriodButton.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
       Intent intent = new Intent(v.getContext(), BudgetPeriod.class);
       startActivity(intent);
    }
});