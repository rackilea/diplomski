List<Bird> birds = new ArrayList<Bird>();
//birds.add();
Intent intent = new Intent(Current.this, Transfer.class);
Bundle bundle = new Bundle();
bundle.putParcelableArrayList("Birds", birds);
intent.putExtras(bundle);
startActivity(intent);