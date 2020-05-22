<cc:implementation>
    <ui:decorate template="/WEB-INF/templates/someCommonTemplate.xhtml">
        <ui:define name="input">
            <h:inputText id="myinput" value="#{cc.attrs.value}">
                <f:convertNumber minFractionDigits="2" />
                <f:validator validatorId="bindableDoubleRangeValidator"/>
                <f:attribute name="minimum" value="#{cc.attrs.min}"/>
                <f:attribute name="maximum" value="#{cc.attrs.max}"/>
            </h:inputText>
        </ui:define>
    </ui:decorate>
</cc:implementation>