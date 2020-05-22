<script th:inline="javascript">
jQuery(document).ready(function($){
    $("#filterModal").submit(function() {
        $(this)
            .find(":input")
            .filter(function(){ return !this.value; })
            .attr("disabled", "disabled");
        return true;
    });
    $("#filterModal")
        .find( ":input" )
        .prop( "disabled", false );
});</script>