// Now, let's attach it to your timestamps on DOM ready:
// This will turn all abbr elements with a class of timeago and an ISO 8601 timestamp in the title: 

jQuery(document).ready(function() {

  jQuery("abbr.timeago").timeago();
});