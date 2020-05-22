<script>
$(function(){
    var myVar = '<%= request.getSession().getAttribute("admin_id") %>';
    changeYourPassword();
    latestNoticeCheck();
});
....
</script>