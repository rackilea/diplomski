...
<script>
   $.ajax({
      url: "/getValues",
      type: "GET",
      success: function(result){
          //result is a json object containing your values 1..4.
      },
      failure: functtion(err){...}
   });
</script>