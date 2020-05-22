if ("b".equalsIgnoreCase(str)) {
        String text = fb.getDocument().getText(0, 1);
        super.replace(fb, 0, fb.getDocument().getLength(), text, attr);
    } else {
        super.replace(fb, offset, length, str, attr);
    }