<listbox id="listModel" rows="20"
                                    fixedLayout="true" span="true" mold="paging" pageSize="20">
                                    <listhead>
                                        <listheader id="${each}"
                                            label="${each}" width=" 250px"
                                            forward="onDoubleClick=onRemoveFromHeader"
                                            forEach="${comboModelColumns}" visible="false" />
                                        <custom-attributes
                                            headers="${each}" />


                                    </listhead>
                                    <listitem
                                        forEach="${listValues}">
                                        <listcell
                                            forEach="${listValues[forEachStatus.index]}"
                                            label="${each}" />
                                    </listitem>

                                </listbox>