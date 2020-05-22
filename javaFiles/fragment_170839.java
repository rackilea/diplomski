<xp:eventHandler
    event="onClientLoad"
    submit="false">
    <xp:this.script><![CDATA[
        dojo.query("[id$=editBudgetCode]").forEach(function(node) {
          dojo.connect(node, "onchange", function() { 
                var newValue = this.value; 
                var boundto = dojo.attr(this, "boundto");
                dojo.query("[id$=editBudgetCode]").forEach(function(node) {
                    if (boundto === dojo.attr(node, "boundto")) {
                        node.value = newValue;
                    }
                });
          });
        });]]>
    </xp:this.script>
</xp:eventHandler>