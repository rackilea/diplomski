CopyOnWriteArrayList<String> l = new CopyOnWriteArrayList<>();
String s1 = new String("foo");
String s2 = new String("bar"); 
String s3 = new String("bar"); // Different object, same value

l.add(s1);
Log.e("TEST", "Result: "+String.valueOf( s1 == l.get(0) ));

l.add(s2);
Log.e("TEST", "Result: "+String.valueOf( s1 == l.get(0) ));
Log.e("TEST", "Result: "+String.valueOf( s2 == l.get(1) ));

l.add(s3);
Log.e("TEST", "Result: "+String.valueOf( s1 == l.get(0) ));
Log.e("TEST", "Result: "+String.valueOf( s2 == l.get(1) ));
Log.e("TEST", "Result: "+String.valueOf( s3 == l.get(2) ));

l.remove(1); // the s2
Log.e("TEST", "Result: "+String.valueOf( s1 == l.get(0) ));
Log.e("TEST", "Result: "+String.valueOf( s2 == l.get(1) )); // should be false
Log.e("TEST", "Result: "+String.valueOf( s3 == l.get(1) )); // should be true