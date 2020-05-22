if(result.equals("success")) {
    Toast.makeText(ctx,"onpost excute",Toast.LENGTH_LONG).show();        
    Intent intent = new Intent(ctx,mIntentclass.class);
    ctx.startActivity(intent);  

}
   Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
}