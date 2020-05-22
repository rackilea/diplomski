ListViewItem item = items.getItem(position);
String title = item.Title;
String desc = item. Description;
int thumbnail = item. ThumbnailResource;

Intent societyPage = new Intent(SocietySearch.this, SocietyPage.class);
i.putExtra("title", title);
i.putExtra("desc", desc);
i.putExtra("thumbnail", thumbnail);
startActivity(societyPage);