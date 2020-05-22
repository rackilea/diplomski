Map<Integer,JButton> map=new HashMap<Integer,JButton>();

public void keyPressed(KeyEvent evt) {
    keycode = evt.getKeyCode();
    strText = String.format("%s", KeyEvent.getKeyText(evt.getKeyCode()));

    JButton btn = map.get(keycode);
    if (btn != null) {
        map.get(keycode).setBackground(Color.BLUE);
    }

}// end of key pressed

public void keyReleased(KeyEvent evt) {
    keycode = evt.getKeyCode();
    strText = String.format("%s", KeyEvent.getKeyText(evt.getKeyCode()));

    JButton btn = map.get(keycode);
    if (btn != null) {
        map.get(keycode).setBackground(Color.WHITE);
    }
}

protected void addKeys(JPanel parent, int row, String[] keys, JButton[] buttons) {

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridy = row;
    gbc.gridx = 0;
    gbc.fill = GridBagConstraints.BOTH;

    int gap = 0;
    for (int index = 0; index < keys.length; index++) {
        String key = keys[index];
        if ("blank".equalsIgnoreCase(key)) {
            gbc.gridx++;
        } else if ("fill".equalsIgnoreCase(key)) {
            gbc.gridwidth++;
            gap++;
        } else {
            // System.out.println("Add " + key);
            JButton btn = new JButton(key);
            buttons[index] = btn;
            parent.add(btn, gbc);
            gbc.gridx += gap + 1;
            gbc.gridwidth = 1;
            gap = 0;

            System.out.println(key);
            btn.setBackground(Color.WHITE);
            map.put(getKeyCode(key), btn);
        }
    }

}


private int getKeyCode(String key) {
    if (key.equals("BackSpace")) {
        return KeyEvent.VK_BACK_SPACE;
    } else if (key.equals("Tab")) {
        return KeyEvent.VK_TAB;
    } else if (key.equals("Caps")) {
        return KeyEvent.VK_CAPS_LOCK;
    } else if (key.equals("Enter")) {
        return KeyEvent.VK_ENTER;
    } else if (key.equals("Shift")) {
        return KeyEvent.VK_SHIFT;
    } else if (key.equals("")) {
        return KeyEvent.VK_SPACE;
    } else if (key.equals("+")) {
        return KeyEvent.VK_EQUALS;
    }else if (key.equals(":")) {
        return KeyEvent.VK_SEMICOLON;
    }else if (key.equals("\"")) {
        return KeyEvent.VK_QUOTE;
    }else if (key.equals("?")) {
        return KeyEvent.VK_SLASH;
    }else if (key.equals("~")) {
        return KeyEvent.VK_BACK_QUOTE;
    } else if (key.equals("^")) {
        return KeyEvent.VK_UP;
    } else if (key.equals("v")) {
        return KeyEvent.VK_DOWN;
    } else if (key.equals("<")) {
        return KeyEvent.VK_LEFT;
    } else if (key.equals(">")) {
        return KeyEvent.VK_RIGHT;
    } else {
        return (int) key.charAt(0);
    }
}