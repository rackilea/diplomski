<script>
 var id = event.target.id;
 var position;
 var length = percentage.length();
 for(var i=0;i<length;i++){
   if( id == cardTypeId[i]){
    position = i;
    break;
   }
 }
 var percen = percentage[position];
</script>