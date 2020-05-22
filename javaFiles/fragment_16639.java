final AbstractAction[] action = new AbstractAction[1];
   editTemplateButton.setAction(action[0]=new AbstractAction("Edit...", GUIUtils.EDIT_ELEMENT_ICON)
        {
            {
                setEnabled(false); // disabled at start
                templatesList.addListSelectionListener(new ListSelectionListener()
                {
                    @Override
                    public void valueChanged(ListSelectionEvent e)
                    {
                        action[0].setEnabled(!templatesList.isSelectionEmpty()); // depends on selection
                    }
                });
            }

            @Override
            public void actionPerformed(ActionEvent e)
            {
                //todo
            }
        });