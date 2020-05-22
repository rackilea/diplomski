List<JLabel> list1 = new ArrayList<JLabel>();
list1.add(img1);
list1.add(img2);
list1.add(img3);

List<JLabel> list2 = new ArrayList<JLabel>();
list2.add(img1);
list2.add(img4);
list3.add(img5);

ArrayList<JLabel>[][] group = new ArrayList<JLabel>[3][2];  // you need to specify the size of the 2nd dimension here if you don't initialize it before using...
group[0][0] = list1;   // 0-based indexing. assuming this is what you wanted...
group[0][1] = list2;