<zk xmlns:w="client">
    <window title="center win, movable" border="normal"
        position="center,center"
        onCreate="self.doOverlapped();" />
    <window title="top win, not movable" border="normal"
        sclass="z-window-not-movable"
        position="center,top"
        onCreate="self.doOverlapped();">
        <attribute w:name="bind_"><![CDATA[
            function (a, b, c) {
                if (!this.$class.ignoremoveOverridden) {
                    this.$class.ignoremoveOverridden = true;
                    var oldImove = this.$class._ignoremove;
                    this.$class._ignoremove = function (dg, pointer, evt) {
                        var wgt = dg.control;
                        if (jq(wgt.$n()).hasClass('z-window-not-movable')) {
                            return true;
                        }
                        return oldImove.apply(wgt, arguments);
                    }
                }
                this.$bind_(a, b, c);
            }
        ]]></attribute>
    </window>
</zk>