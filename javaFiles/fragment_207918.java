final ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollbar_textchat);
scrollView.post(new Runnable() { 
        public void run() { 
             scrollView.scrollTo(0, scrollView.getBottom());
        } 
});