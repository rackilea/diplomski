Component rComponent = r.getListCellRendererComponent(
                       this, getModel().getElementAt(index), index,
                       lsm.isSelectedIndex(index),
                       (hasFocus() && (lsm.getLeadSelectionIndex() ==
                                       index)));

            if(rComponent instanceof JComponent) {
                MouseEvent      newEvent;

                p.translate(-cellBounds.x, -cellBounds.y);
                newEvent = new MouseEvent(rComponent, event.getID(),
                                          event.getWhen(),
                                          event.getModifiers(),
                                          p.x, p.y,
                                          event.getXOnScreen(),
                                          event.getYOnScreen(),
                                          event.getClickCount(),
                                          event.isPopupTrigger(),
                                          MouseEvent.NOBUTTON);

                String tip = ((JComponent)rComponent).getToolTipText(
                                          newEvent);

                if (tip != null) {
                    return tip;
                }