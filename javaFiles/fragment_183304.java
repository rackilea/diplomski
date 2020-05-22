int a = st.getCharCount();

Font font = new Font(shlProtruleModifier.getDisplay(), "Courier", 10, SWT.NORMAL);

StyleRange[] sr = new StyleRange[1];

sr[0] = new StyleRange();

st.append("\r\nWhat the heck?");

sr[0].start = a;
sr[0].length = st.getCharCount() - a;
sr[0].font = font;
sr[0].foreground = SWTResourceManager.getColor(SWT.COLOR_BLACK);

st.replaceStyleRanges(sr[0].start, sr[0].length, sr);