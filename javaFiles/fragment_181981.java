Intent detailIntent = new Intent(this, ArticleDetailActivity.class);
// detailIntent.putExtra(ArticleDetailFragment.ARG_ITEM_ID, id);
Bundle bundle = new Bundle();
bundle.putSerializable("joke", joke);
detailIntent.putExtras(bundle);
startActivity(detailIntent);