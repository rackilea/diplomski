private void appendTextAndScroll(String text)
{
    runOnUiThread(new Runnable()
    {
        public void run()
        {
            if(text.length() >= 1){
                if(chat_text_chat != null){
                    chat_text_chat.append(text + "\n");
                    final Layout layout = chat_text_chat.getLayout();
                    if(layout != null){
                        int scrollDelta = layout.getLineBottom(chat_text_chat.getLineCount() - 1) - chat_text_chat.getScrollY() - chat_text_chat.getHeight();
                        if(scrollDelta > 0){
                            chat_text_chat.scrollBy(0, scrollDelta);
                        }
                    }
                }
            }
        }
    });
}