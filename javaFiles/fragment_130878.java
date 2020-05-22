FormLayout layout = new FormLayout("file:default:grow","fill:default:grow");
PanelBuilder builder = new PanelBuilder(layout);
CellConstraints cc = new CellConstraints();

layout.appendRow(new RowSpec("pref"));
buiulder.add(new Panel(), cc.xy(1,layout.getRowCount()));