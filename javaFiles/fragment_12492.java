UserMentionEntity[] userMentionEntities = status.getUserMentionEntities();
    for (UserMentionEntity ume : userMentionEntities) {
        final String mention = ume.getText().toLowerCase();
        int mentionStart = text.toLowerCase().indexOf("@" + mention);
        int mentionEnd = mentionStart + mention.length();
        ss.setSpan(new ForegroundColorSpan(Color.parseColor(COLOR)), mentionStart, mentionEnd + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }