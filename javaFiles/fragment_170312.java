final JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final MaskFormatter mask;
        try {
            mask = new MaskFormatter("#####-#######-#");
        } catch (ParseException e) {
            throw new RuntimeException("Invalid format mask specified", e);
        }

        // You can optionally set a placeholder character by doing the following:
        mask.setPlaceholderCharacter('_');
        final JFormattedTextField formattedField = new JFormattedTextField(mask);

        frame.setSize(100, 100);
        frame.add(formattedField);
        frame.setVisible(true);