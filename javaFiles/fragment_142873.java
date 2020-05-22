<group name="citygroup">
    <groupExpression><![CDATA[$F{city}]]></groupExpression>
    <groupHeader>
        <band height="20">
            <textField>
                <reportElement x="0" y="0" width="100" height="20"/>
                <textElement/>
                <textFieldExpression><![CDATA["City: " + $F{city}]]></textFieldExpression>
            </textField>
        </band>
    </groupHeader>
    <groupFooter>
        <band height="21">
            <textField>
                <reportElement x="0" y="1" width="100" height="20">
                    <!-- Outline row group ends here-->
                    <property name="net.sf.jasperreports.export.xls.row.outline.level.1" value="End"/>
                </reportElement>
                <textElement/>
                <textFieldExpression><![CDATA["Total: " + $V{citygroup_COUNT}]]></textFieldExpression>
            </textField>
        </band>
    </groupFooter>
</group>
<detail>
    <band height="20" splitType="Stretch">
        <textField>
            <reportElement x="0" y="0" width="100" height="20">
                <!-- Outline row group starts here-->
                <property name="net.sf.jasperreports.export.xls.row.outline.level.1" value="Body"/>
            </reportElement>
            <textElement/>
            <textFieldExpression><![CDATA[$F{id}]]></textFieldExpression>
        </textField>
        <textField>
            <reportElement x="100" y="0" width="100" height="20"/>
            <textElement/>
            <textFieldExpression><![CDATA[$F{name}]]></textFieldExpression>
        </textField>
        <textField>
            <reportElement x="200" y="0" width="100" height="20"/>
            <textElement/>
            <textFieldExpression><![CDATA[$F{address}]]></textFieldExpression>
        </textField>
    </band>
</detail>