<rich:autocomplete mode="ajax" showButton="true"
    layout="table" autocompleteMethod="#{patientSearch.searchPatientByAll}"
    autocompleteList="#{patientSearch.searchPatient}"
    fetchValue="#{patient.patientId}" id="txtPatientSearch" var="patient">
  <rich:column>
    <h:graphicImage value="/resources/images/default.png" />
  </rich:column>
  <rich:column>
    <h:outputText value="#{patient.fname}" />
  </rich:column>
  <rich:column>
    <h:outputText value="#{patient.lname}" />
  </rich:column>
  <rich:column>
    <h:outputText value="#{patient.gender}" />
  </rich:column>
  <rich:column>
    <h:outputText value="#{patient.mrn}" />
  </rich:column>
</rich:autocomplete>