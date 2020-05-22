Label lbs[];

lbs=new Label[7];

String strings_en[]=new String[]{
"fajr",
"zuhr",
"asr",
"maghrib",
"isha",
"hadith",
"fajr_lefthour"
};

String strings_ar[]=new String[]{
"فجر",
"ظهر",
"عصر",
"مغرب",
"عشاء",
"حديث",
"فجر ساعة لاحقة"
};

String strings[];
//assing lan list
strings=strings_ar; // or strings=strings_en;


        for (int i = 0; i < lbs.length; i++) {
            lbs[i]=new Label(strings[i]);//initializing labels
            //doing what you want here with labels 
            //...

        }