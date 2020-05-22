Mylecture f = new Mylecture();
Bundle args = new Bundle();
args.putString("key_one", url_one);
f.setArguments(args);

// adapter.addFragment(new Mylecture(), "Lectures"); // Do not new a fragment
adapter.addFragment(f, "Lectures"); // Use this instead