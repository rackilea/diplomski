<summary>
    <band height="20">
        <textField evaluationTime="Report">
            <reportElement x="0" y="0" width="200" height="20" isRemoveLineWhenBlank="true" forecolor="#FF0033" uuid="82b89600-1787-4a86-809e-adc5babdd6b6">
                <printWhenExpression><![CDATA[$V{REPORT_COUNT}.intValue()>=$P{REPORT_MAX_COUNT}.intValue()]]></printWhenExpression>
            </reportElement>
            <textElement textAlignment="Center" verticalAlignment="Middle"/>
            <textFieldExpression><![CDATA["REPORT_MAX_COUNT HIT"]]></textFieldExpression>
        </textField>
    </band>
</summary>