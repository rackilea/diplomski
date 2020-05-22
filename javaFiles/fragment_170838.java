<xp:eventHandler
    event="onClientLoad"
    submit="false">
    <xp:this.script><![CDATA[
        dojo.query("[id$=editBudgetCode]").forEach(function(node) {
          dojo.connect(node, "onchange", function() { 
                var newValue = this.value; 
                dojo.query("[id$=editBudgetCode]").forEach(function(node) {
                    node.value = newValue;
                });
          });
        });]]>
    </xp:this.script>
</xp:eventHandler>