function validate(sdd_ejrp_form) {

  var duplicateRanksDetected = []; //create an array here

  var validate_rank_str = ",";
  jq("\[data-dom-id=gsc-containers\]").find("\[data-dom-id=gsc-container\]").each(function(index) {
    var jqThis = jq(this);
    var gsc_uri = jqThis.attr("data-gsc-data-gsc-uri");
    var prof_lvl_rank = jqThis.find("select\[name='prof-lvl-rank'\]").val();
    jqThis.find("\[data-dom-id=proficiency-level\]").each(function(index2) {
      var btn = jq(this);
      if (btn.hasClass("active")) {
        if (validate_rank_str.indexOf("," + prof_lvl_rank + ",") != -1) {

          duplicateRanksDetected.push(prof_lvl_rank); // fill the array here

          return false;
        } else {
          validate_rank_str += prof_lvl_rank + ",";
        }
      }
    });
  });

  if (duplicateRanksDetected.length > 0) {
    // here I want to display exactly which rank is duplicated
    alert(
      "Duplicate ranks detected: " +
      duplicateRanksDetected.join(', ') // display the result here
    );
    return false;
  }
}