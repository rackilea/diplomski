<style type="text/css">
    .lishShuttle td{vertical-align:top;}
   </style>

      <rich:listShuttle id="companyJurisdictionShutle"
                                  sourceValue="#{companyAdminAction.jurisdictionList}"
                                  targetValue="#{companyAdminAction.targetJurisdictionList}"
                                  converter="#{dmpJurisdictionConverter}"
                                  rowKeyConverter="dmpJurisdictionConverter"
                                  rowClasses=""
                                  var="item" orderControlsVisible="false" fastOrderControlsVisible="false"
                                  sourceCaptionLabel="Available"
                                  targetCaptionLabel="Selected" styleClass="lishShuttle">
                    <rich:column>
                        #{item}
                    </rich:column>
                </rich:listShuttle>