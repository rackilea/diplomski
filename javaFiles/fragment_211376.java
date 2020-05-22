<window id="menu" visible="false" closable="true" position="center" width="400px" height="150px" border="normal" title="Reorder" apply="test.MenuViewCtrl">
    <listbox id="box">
        <template name="model">
            <listitem label="${each.label}" draggable="move" droppable="move" />
        </template>
    </listbox>
</window>