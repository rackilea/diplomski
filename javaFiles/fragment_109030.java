<TablePane styles="{padding:8, horizontalSpacing:6, verticalSpacing:6}">
    <columns>
        <TablePane.Column width="1*" />
    </columns>

    <TablePane.Row height="-1">                     
        <Label text="Triggers:" />
    </TablePane.Row>

    <TablePane.Row height="1*">
        <ScrollPane
            horizontalScrollBarPolicy="fill"
            verticalScrollBarPolicy="fill_to_capacity"
            >
            <ListView bxml:id="listTriggers" selectMode="single"
                listData="['TRNIF_Trigger1'],['TRNIF_Trigger2'],['TRNIF_Trigger3']"
            />
        </ScrollPane>
    </TablePane.Row>
</TablePane>