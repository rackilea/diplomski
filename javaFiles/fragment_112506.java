//JScrollPane split_jsp = new JScrollPane( split_pane );
//split_jsp.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER );

ScrollablePanel scrollable = new ScrollablePanel( new BorderLayout() );
scrollable.setScrollableHeight( ScrollablePanel.ScrollableSizeHint.FIT );
scrollable.setScrollableWidth( ScrollablePanel.ScrollableSizeHint.STRETCH );
scrollable.add(split_pane);
JScrollPane split_jsp = new JScrollPane( scrollable );