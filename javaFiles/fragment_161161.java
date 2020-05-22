public List<TextView> createTextViews(Context context, List<AthenaPanel> athenaPanelList) {
   ArrayList<TextView> textViewList = new ArrayList<>();

   if(athenaPanelList != null && athenaPanelList.size() > 0) {
      for(AthenaPanel athenaPanel : athenaPanelList) {
         TextView textView = new TextView(context);
         textView.setText(athenaPanel.getTitle());
         textViewList.add(textView);
      }
   }

   return textViewList;
}