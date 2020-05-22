<a4j:region renderRegionOnly="true">

        <%-- Year filter --%>
        <h:selectOneMenu id="minYear" value="#{statistics.minYear}" 
                         style="width: 75px" onchange="this.form.submit()"
                         valueChangeListener="#{statistics.minYearChanged}">
            <f:selectItems value="#{statistics.minYearValues}" />
        </h:selectOneMenu>

        <f:verbatim>&#160;&#160;</f:verbatim>
        <h:outputText value="#{bundleStatistics['Label.minYearToMaxYear']}" />
        <f:verbatim>&#160;&#160;</f:verbatim>

        <h:selectOneMenu id="maxYear" value="#{statistics.maxYear}" 
                         style="width: 75px" onchange="this.form.submit()"
                         valueChangeListener="#{statistics.maxYearChanged}">
            <f:selectItems  value="#{statistics.maxYearValues}"/>
        </h:selectOneMenu>
    <%-- end year filter--%>

</a4j:region>