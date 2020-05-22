// write parcelable array
final Bundle arguments = new Bundle();
MyParcelable[] myArray = new MyParcelable[10];
arguments.putParcelableArray("key"myArray);

// read parcelable array
MyParcelable[] myArray = (MyParcelable[])getArguments().getParcelableArray("key");