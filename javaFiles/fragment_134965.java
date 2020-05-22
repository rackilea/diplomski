<jr:table xmlns:jr="http://jasperreports.sourceforge.net/jasperreports/components" xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports/components http://jasperreports.sourceforge.net/xsd/components.xsd">
                    <datasetRun subDataset="Dataset1" uuid="c9a09593-11ee-4817-95f6-bd2903bdf820">
                        <datasetParameter name="ulInfo">
                            <datasetParameterExpression><![CDATA["ID Клиента в Мастер-системе – "+$F{clientId}+", ИНН – "+$F{inn} +", Наименование - " + $F{shortName}]]></datasetParameterExpression>
                        </datasetParameter>
                        <datasetParameter name="flInfo">
                            <datasetParameterExpression><![CDATA["ФИО - " + $F{clientFIO} + ", дата рождения - " + $F{clientBirthDate}]]></datasetParameterExpression>
                        </datasetParameter>
                        <dataSourceExpression><![CDATA[((net.sf.jasperreports.engine.data.JRXmlDataSource)$P{REPORT_DATA_SOURCE}).subDataSource("/report/stopListInfos/slInfo")]]></dataSourceExpression>
                    </datasetRun>
                    <jr:column width="120" uuid="aa9f5289-56ad-47df-93cf-8a81770ecd4c">
                        <property name="com.jaspersoft.studio.components.table.model.column.name" value="Column1"/>
                        <jr:detailCell style="Table_TD" height="80">
                            <staticText>
                                <reportElement x="0" y="0" width="120" height="20" uuid="9fa05583-38e1-4cd2-b717-7f953ed29042">
                                    <property name="com.jaspersoft.studio.unit.height" value="pixel"/>
                                </reportElement>
                                <textElement>
                                    <font fontName="Times New Roman" size="12" isBold="true"/>
                                </textElement>
                                <text><![CDATA[Код Стоп-листа:]]></text>
                            </staticText>
                            <staticText>
                                <reportElement x="0" y="20" width="120" height="20" uuid="915e8324-e9b9-452d-983c-3e241f34eb46"/>
                                <textElement>
                                    <font fontName="Times New Roman" size="12" isBold="true"/>
                                </textElement>
                                <text><![CDATA[Тип клиента:]]></text>
                            </staticText>
                            <staticText>
                                <reportElement x="0" y="40" width="120" height="20" uuid="fc7a9e65-2573-405d-bd3f-c519bd93d162">
                                    <property name="com.jaspersoft.studio.unit.height" value="pixel"/>
                                </reportElement>
                                <textElement>
                                    <font fontName="Times New Roman" size="12" isBold="true"/>
                                </textElement>
                                <text><![CDATA[Реквизиты клиента:]]></text>
                            </staticText>
                            <staticText>
                                <reportElement x="0" y="60" width="120" height="20" uuid="df0465cc-c3ab-4393-a12a-817c1ff749c7">
                                    <property name="com.jaspersoft.studio.unit.height" value="pixel"/>
                                </reportElement>
                                <textElement>
                                    <font fontName="Times New Roman" size="12" isBold="true"/>
                                </textElement>
                                <text><![CDATA[]]></text>
                            </staticText>
                        </jr:detailCell>
                    </jr:column>
                    <jr:column width="400" uuid="82a313a6-2d55-418e-af19-a3ff9439bd6a">
                        <property name="com.jaspersoft.studio.components.table.model.column.name" value="Column2"/>
                        <jr:detailCell style="Table_TD" height="80">
                            <textField>
                                <reportElement x="0" y="0" width="400" height="20" uuid="003483c6-9aa4-43fe-8d8c-2a5aef9ccc3f"/>
                                <textElement>
                                    <font fontName="Times New Roman" size="12"/>
                                </textElement>
                                <textFieldExpression><![CDATA[$F{stopListCode} + " " +$F{stopListResult}]]></textFieldExpression>
                            </textField>
                            <textField>
                                <reportElement x="0" y="20" width="400" height="20" uuid="f3f7f9f6-7482-41a7-a473-0fa5d1a4bbed"/>
                                <textElement>
                                    <font fontName="Times New Roman" size="12"/>
                                </textElement>
                                <textFieldExpression><![CDATA[$F{clientType}]]></textFieldExpression>
                            </textField>
                            <textField>
                                <reportElement x="0" y="40" width="400" height="20" uuid="8ca9059f-7c71-44ff-96fd-7b490d4f7c0e">
                                    <property name="com.jaspersoft.studio.unit.height" value="pixel"/>
                                </reportElement>
                                <textElement>
                                    <font fontName="Times New Roman" size="12"/>
                                </textElement>
                                <textFieldExpression><![CDATA[$F{clientType}.equals("ЮЛ") ? $P{ulInfo} : $P{flInfo}]]></textFieldExpression>
                            </textField>
                            <staticText>
                                <reportElement x="0" y="60" width="400" height="20" uuid="19825a9f-d99a-4a98-b143-9fa91edc37a6">
                                    <property name="com.jaspersoft.studio.unit.height" value="pixel"/>
                                </reportElement>
                                <textElement>
                                    <font fontName="Times New Roman" size="12" isBold="true"/>
                                </textElement>
                                <text><![CDATA[]]></text>
                            </staticText>
                        </jr:detailCell>
                    </jr:column>
                </jr:table>