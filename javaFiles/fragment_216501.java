<script>

    function submitForm(btn){
        var frm = document.myform;

        frm.action.value = btn.value;
        frm.submit();
        return false;

    }

</script>