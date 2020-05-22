<rich:dataTable (..some attributes..)
    onkeypress="if (event.keyCode == 13) {document.getElementById('formId:tableId:j_id70fsp').blur(); return false;} else {return true;}"
    ><!-- disabling submit-on-enter -->
    <rich:column label="#{msg.name}" sortable="true" 
       filterBy="#{patient.profile.name}" filterEvent="onblur">
</rich:dataTable>