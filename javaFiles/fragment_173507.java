confirmBtn.setOnClickListener(new OnclickListener{

Intent intent = new Intent();  
intent.putExtra("updatedCost", totalCostValue);  
setResult(121, intent);
finish();

});