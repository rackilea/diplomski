package com.example.hero;

import java.util.ArrayList;

public class Hero implements Parcelable {

    String heroName;

    int primaryWeapon;

    ArrayList<Integer> allWeapons;

    boolean canFly;


    protected Hero(Parcel in) {
        heroName = in.readString();
        primaryWeapon = in.readInt();
        if (in.readByte() == 0x01) {
            allWeapons = new ArrayList<Integer>();
            in.readList(allWeapons, Integer.class.getClassLoader());
        } else {
            allWeapons = null;
        }
        canFly = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(heroName);
        dest.writeInt(primaryWeapon);
        if (allWeapons == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(allWeapons);
        }
        dest.writeByte((byte) (canFly ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Hero> CREATOR = new Parcelable.Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel in) {
            return new Hero(in);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };
}