**<af:panelTabbed id="pt1">**
    <af:showDetailItem text="File Upload" id="sdi1"
                       styleClass="AFStretchWidth">
      <af:inputText value="#{bindings.InvoiceNumber.inputValue}"
                    label="#{bindings.InvoiceNumber.hints.label}"
                    required="#{bindings.InvoiceNumber.hints.mandatory}"
                    columns="#{bindings.InvoiceNumber.hints.displayWidth}"
                    maximumLength="#{bindings.InvoiceNumber.hints.precision}"
                    shortDesc="#{bindings.InvoiceNumber.hints.tooltip}"
                    id="it31">
        <f:validator binding="#{bindings.InvoiceNumber.validator}"/>
      </af:inputText>
      <af:spacer width="20" height="20" id="s2"/>
      <af:inputFile id="if1" autoHeightRows="0" label="File:"
                    value="#{UploadTelephoneUsageBean.uploadFile}"
                    valueChangeListener="#{UploadTelephoneUsageBean.fileUploaded}"/>
      <af:spacer width="10" height="10" id="s1"/>
      <af:commandButton text="Upload" id="cb1" partialSubmit="true"
                        actionListener="#{UploadTelephoneUsageBean.check_file_upload}"/>
    </af:showDetailItem>
  **</af:panelTabbed>**