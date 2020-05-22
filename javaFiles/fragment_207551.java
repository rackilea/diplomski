private void drawMessageString(Graphics2D g, final int messageHeight) {
        int x = CRUSH_PADDING + CRUSH_MESSAGE_LR_PADDING;
        int y = CRUSH_PADDING + TOP_BAR_HEIGHT + CRUSH_MESSAGE_TB_PADDING;

            String myString="he new guy from New Zealand who is playing tennis   ";


            try {
                byte ptext[] = myString.getBytes("UTF-8");
                    String value;
                value = new String(ptext, "UTF-8");
                TextRenderer.drawString(g, value, FontUtils.getInstance().getFont(FONT_OPEN_EMOJIFONT, 24.0f), MSG_COLOR, new Rectangle(x, y, CRUSH_MESSAGE_WIDTH, messageHeight), TextAlignment.TOP, TextFormat.FIRST_LINE_VISIBLE);

            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }