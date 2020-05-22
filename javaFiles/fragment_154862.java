Intent blog = new Intent(DetailActivity.this, ReportActivity.class);
 blog .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 blog.putExtra("URL", "url");
 blog.putExtra("filename", "Blog");
 startActivity(blog);
 finish();