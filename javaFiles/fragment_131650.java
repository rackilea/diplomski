{
  xtype:"panel",
  border:false,
  layout:"hbox",
  jcr:  primaryType:"cq:Widget",
  items:{
    jcr:    primaryType:"cq:WidgetCollection",
    label:{
      flex:"30",
      xtype:"label",
      jcr:      primaryType:"cq:Widget",
      text:"Date Time"
    },
    datefield:{
      flex:"40",
      xtype:"datefield",
      name:"./date",
      jcr:      primaryType:"cq:Widget"
    },
    timefield:{
      flex:"30",
      xtype:"timefield",
      name:"./time",
      jcr:      primaryType:"cq:Widget"
    }
  }
}