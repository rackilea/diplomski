Group horizontalGroup = layout.createSequentialGroup();
fields.forEach(field -> horizontalGroup.addComponent(field));
layout.setHorizontalGroup(horizontalGroup);

Group verticalGroup = layout.createParallelGroup();
fields.forEach(field -> verticalGroup.addComponent(field));
layout.setVerticalGroup(verticalGroup);

layout.linkSize(fields.toArray(new Component[0]));             // <-- ADDITION