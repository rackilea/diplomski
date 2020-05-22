JLabel messageLabel = new JLabel("Background is cyan!") {
        /**
         * {@inheritDoc}
         */
        @Override
        public void addNotify() {
            super.addNotify();
            if (getRootPane() != null) {
                List<Component> children = findAllChildren(getRootPane());
                for (Component comp : children) {
                    if (!(comp instanceof JButton)) {
                        comp.setBackground(Color.CYAN);
                    }
                }
            }
        }

        private List<Component> findAllChildren(Component aComp) {
            List<Component> result = new ArrayList<Component>();
            result.add(aComp);
            if (aComp instanceof Container) {
                Component[] children = ((Container) aComp).getComponents();
                for (Component c : children) {
                    result.addAll(findAllChildren(c));
                }
            }
            return result;
        }
    };
    JOptionPane.showConfirmDialog(null, messageLabel, "Test title", JOptionPane.YES_NO_CANCEL_OPTION);