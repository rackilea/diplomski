public class MyParcelable implements Parcelable {

     private String str1;
     private String str2;
     private String str3;
     private String str4;
     private String str5;
     private String str6;
     private String str7;
     private String str8;
     private String str9;
     private String str10;

     public int describeContents() {
         return 0;
     }

     public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(str1);       
      dest.writeString(str2);   
      dest.writeString(str3);   
      dest.writeString(str4);   
      dest.writeString(str5);   
      dest.writeString(str6);   
      dest.writeString(str7);   
      dest.writeString(str8);   
      dest.writeString(str9);
      dest.writeString(str10);
     }

     public static final Parcelable.Creator<MyParcelable> CREATOR
             = new Parcelable.Creator<MyParcelable>() {
         public MyParcelable createFromParcel(Parcel in) {
             return new MyParcelable(in);
         }

         public MyParcelable[] newArray(int size) {
             return new MyParcelable[size];
         }
     };

     private MyParcelable(Parcel in) {
         str1 = in.readString();       
         str2 = in.readString();       
         str3 = in.readString();       
         str4 = in.readString();       
         str5 = in.readString();       
         str6 = in.readString();       
         str7 = in.readString();       
         str8 = in.readString();       
         str9 = in.readString();       
         str10 = in.readString();       
     }
 }