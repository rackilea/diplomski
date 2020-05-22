if(holder != null ){

   if(model != null){
      holder.textViewName.setText(model.getName());
      holder.Plan.setText(model.getTypeOfPlan());
      holder.Price.setText(model.getPrice());
   }else
      Log.e(getClass().getSimpleName(),"model object is Null...");
}else 
  Log.e(getClass().getSimpleName(), "holder object is null...");