adView = new AdView(LoaderActivity.m_Activity,AdSize.BANNER, appKeyFinal);      
RelativeLayout layout = new RelativeLayout(LoaderActivity.m_Activity);
RelativeLayout.LayoutParams parentParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);

RelativeLayout.LayoutParams adNinjaLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
adNinjaLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
LoaderActivity.m_Activity.addContentView(layout,parentParams);
adView.loadAd(adRequest);