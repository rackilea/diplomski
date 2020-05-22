@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    iv = (ImageView) findViewById(R.id.imageView1);

    Bundle bundle = getIntent().getExtras();
    String selectedClass = "";

    if(bundle != null){
        selectedClass = bundle.getString("SELECTED_CLASS");
    }

    String imageUrl = "";

     if (selectedClass.equalsIgnoreCase("PERP - BILIK SEMINAR 1"))
        imageUrl = "http://192.168.1.10/timetable/class/bs1.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - BILIK SEMINAR 2"))
        imageUrl = "http://192.168.1.10/timetable/class/bs2.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - BILIK TUTORIAL 1"))
        imageUrl = "http://192.168.1.10/timetable/class/bt1.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - BILIK TUTORIAL 2"))
        imageUrl = "http://192.168.1.10/timetable/class/bt2.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - BILIK TUTORIAL 3"))
        imageUrl = "http://192.168.1.10/timetable/class/bt3.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - BILIK TUTORIAL 4"))
        imageUrl = "http://192.168.1.10/timetable/class/bt4.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - BILIK TUTORIAL 5"))
        imageUrl = "http://192.168.1.10/timetable/class/bt5.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - BILIK TUTORIAL 6"))
        imageUrl = "http://192.168.1.10/timetable/class/bt6.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - BILIK TUTORIAL 7"))
        imageUrl = "http://192.168.1.10/timetable/class/bt7.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - BILIK TUTORIAL 8"))
        imageUrl = "http://192.168.1.10/timetable/class/bt8.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - BILIK TUTORIAL 9"))
        imageUrl = "http://192.168.1.10/timetable/class/bt9.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - BILIK TUTORIAL 10"))
        imageUrl = "http://192.168.1.10/timetable/class/bt10.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - DEWAN KULIAH 1"))
        imageUrl = "http://192.168.1.10/timetable/class/dk1.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - DEWAN KULIAH 2"))
        imageUrl = "http://192.168.1.10/timetable/class/dk2.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - DEWAN KULIAH 3"))
        imageUrl = "http://192.168.1.10/timetable/class/dk3.jpg";
    else if (selectedClass.equalsIgnoreCase("PERP - DEWAN KULIAH 4"))
        imageUrl = "http://192.168.1.10/timetable/class/dk4.jpg";

    bitmap = getBitmapFromURL(imageUrl);
    iv.setImageBitmap(bitmap);

    mAttacher = new PhotoViewAttacher(iv);
}