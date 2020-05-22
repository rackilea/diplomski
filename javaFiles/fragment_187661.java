int removedSymbolCount = 0;
    if (firstIndex >= 0) {
        note = note.replaceFirst("[*]{1}", "");
        removedSymbolCount++;
        int secIndex = note.indexOf("*");
        if (secIndex >= 0) {
            note = note.replaceFirst("[*]{1}", "");
            removedSymbolCount++;
            String newString = "➥ "+note;
            Spannable spannable = new SpannableString(newString);
            spannable.setSpan(new ForegroundColorSpan(Color.YELLOW), firstIndex + removedSymbolCount, secIndex + removedSymbolCount, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannable.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD_ITALIC), firstIndex + removedSymbolCount, secIndex + removedSymbolCount, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            txtnote.setText(spannable);
        }
    }