editor.myCombo = new Ext.form.ComboBox({
    mode: 'local',
    editable: false,
    forceSelection: true,           
    triggerAction: 'all',
    store: new Ext.data.JsonStore({
        fields: ['myId', 'myName'],
        emptyItem: {'myName' : '...'},
        data: <c:out value="${form.json['myList']}" escapeXml="false"/>         
    }),
    disabled: isEditorDisabled,
    width: 75,
    listWidth: 160,
    displayField: 'myName',
    valueField: 'myId',

    // this should return the decoded string instead
    getDisplayValue: function() {
        return Ext.String.htmlDecode(this.value);
    }
});